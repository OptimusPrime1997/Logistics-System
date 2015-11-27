package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Const;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import RMIClient.GoodsClient;
import VO.GoodsVO;
import bl.managementbl.constbl.Constbl;
import dataservice.goodsdataservice.GoodsDataService;

public class Goodsbl {
	/*
	 * ECONOMIC NORMAL EXPRESS 18: 23: 25
	 */
	final double[] expressRates = { 18, 23, 25 };

	public GoodsVO check(String listNum) {
		GoodsVO vo = null;
		try {
			vo = new GoodsVO(getGoodsDataService().findbygoods(listNum));
		} catch (RemoteException e) {
		}
		return vo;
	}
	public ResultMessage init(GoodsVO vo) {
		if (vo.expressType == null || vo.nameOfInside == null
				|| vo.receiverAddress == null || vo.receiverName == null
				|| vo.receiverPhone == null || vo.senderAddress == null
				|| vo.senderName == null || vo.senderPhone == null
				|| vo.weight == 0) {
			return ResultMessage.NOT_COMPLETED;
		}
		if (vo.numOfGoods < 0 || vo.numOfGoods > 100)
			return ResultMessage.UNREASONABLE_GOODS_NUM;
		else if (vo.receiverPhone.length() != 11
				|| vo.senderPhone.length() != 11)
			return ResultMessage.PHONE_LENGTH_WRONG;
		else if (vo.weight < 0 || vo.weight > 100)
			return ResultMessage.UNREASONABLE_WEIGHT_NUM;
		else if (vo.volume < 0 || vo.volume > 100)
			return ResultMessage.UNREASONABLE_VOLUME_NUM;

		return ResultMessage.SUCCESS;
	}

	public GoodsVO getCalculatedGoods(GoodsVO vo) {
		Constbl constBL = new Constbl();
		//TODO the parameter of the findByConstName function is to be modified
		try {
			// TODO 计算运费
			double basicprice = constBL.findByConstName(Const.FARE).priceConst;
			double distance = constBL.findByConstName(Const.DISTANCE).distanceConst;

			vo.moneyFare = moneyCounter(vo.expressType, vo.weight, distance,
					basicprice);
			vo.moneyTotal = vo.moneyFare + vo.moneyOfPackage;
			getGoodsDataService().add(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
		}
		return vo;
	}

	public ResultMessage delete(GoodsVO vo) {
		try {
			return getGoodsDataService().delete(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	public ArrayList<GoodsVO> getGoodsByCourier(String courierNum) {
		ArrayList<GoodsVO> vos = null;
		try {
			vos = GoodsVO.toVOArray(getGoodsDataService().findbyCourier(
					courierNum));
		} catch (RemoteException e) {
		}
		return vos;
	}

	public ArrayList<GoodsVO> getGoodsByGetCourier(String courierNum) {
		ArrayList<GoodsVO> vos = null;
		try {
			vos = GoodsVO.toVOArray(getGoodsDataService().findbyGetCourier(
					courierNum));
		} catch (RemoteException e) {
		}
		return vos;
	}

	public ResultMessage setArrivalState(String listNum, GoodsArrivalState state) {
		try {
			GoodsVO vo = check(listNum);
			vo.arrivalState = state;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	public ResultMessage setLogisticState(String listNum,
			GoodsLogisticState state) {
		try {
			GoodsVO vo = check(listNum);
			vo.logisticState = state;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	public ResultMessage examine(String listNum, Boolean ifPassed) {
		try {
			GoodsVO vo = check(listNum);
			vo.ifExaminePassed = ifPassed;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	public ResultMessage end(String listNum, String realReceiverName,String realReceiverPhone) {
		try {
			GoodsVO vo = check(listNum);
			vo.realReceiverName = realReceiverName;
			vo.realReceiverPhone = realReceiverPhone;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	private double moneyCounter(GoodsExpressType expressType, double weight,
			double distance, double basicPrice) {
		double fare = 0;
		// calculate the unit price of different types
		if (expressType == GoodsExpressType.ECONOMIC)
			basicPrice = basicPrice * expressRates[0] / expressRates[1];
		else if (expressType == GoodsExpressType.EXPRESS)
			basicPrice = basicPrice * expressRates[2] / expressRates[1];
		// calculate the fare
		fare = basicPrice * distance * weight;
		return fare;
	}

	private GoodsClient client = new GoodsClient();

	private GoodsDataService getGoodsDataService() {
		try {
			return client.getGoodsDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
