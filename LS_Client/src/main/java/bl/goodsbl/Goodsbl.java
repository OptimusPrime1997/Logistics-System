package bl.goodsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import util.CurrentTime;
import util.enumData.Const;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import Exception.ExistException;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.loginbl.Loginbl;
import bl.managementbl.constbl.Constbl;
import dataservice.goodsdataservice.GoodsDataService;

public class Goodsbl {
	/*
	 * ECONOMIC NORMAL EXPRESS 18: 23: 25
	 */
	final double[] expressRates = { 18, 23, 25 };
	public static void main(String[] args) {
		Goodsbl bl=new Goodsbl();
		GoodsVO vo=new GoodsVO(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0,0,0,null,GoodsExpressType.ECONOMIC,0,0,0,GoodsArrivalState.BROKEN,GoodsLogisticState.BROKEN_OR_LOST
				,null,null);
		try {
			bl.initComplete(vo);
		} catch (ExistException e) {
		System.out.println("已存在");
		}
	}
	/**
	 * 查物流信息
	 * @param listNum
	 * @return
	 */
	public GoodsVO check(String listNum) throws GoodsNotFound{
		GoodsVO vo = null;
		try {
			vo = new GoodsVO(getGoodsDataService().findbygoods(listNum));
		} catch (RemoteException e) {
		}
		return vo;
	}
	/**
	 * 填写新订单
	 * @param vo
	 * @return填写的信息是否符合规格
	 */
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
	/**
	 * 不对应用例，由init()调用
	 * @param vo
	 * @return返回计算过费用的GoodsVO
	 */
	public GoodsVO initComplete(GoodsVO vo) throws ExistException{//TODO可能初始化失败！没有反馈给界面
		Constbl constBL = new Constbl();
		ResultMessage msg;
		//TODO the parameter of the findByConstName function is to be modified
		try {
			// TODO 计算运费
			double basicprice = 0;//constBL.findByConstName(Const.FARE).priceConst;
			double distance = 0;//constBL.findByConstName(Const.DISTANCE).distanceConst;

			vo.moneyFare = moneyCounter(vo.expressType, vo.weight, distance,
					basicprice);
			vo.moneyTotal = vo.moneyFare + vo.moneyOfPackage;
		   msg=getGoodsDataService().add(GoodsVO.toPO(vo));
		   //已添加过该订单号
		   if(msg.equals(ResultMessage.EXIST)) throw new ExistException();
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
	
	/**
	 * 
	 * @param courierNum
	 * @return返回快递员收件的货物的VO（辅助收款单的填写）
	 */
	public ArrayList<GoodsVO> getGoodsByGetCourier(String courierNum,String date) {
		ArrayList<GoodsVO> vos = null;
		try {
			vos = GoodsVO.toVOArray(getGoodsDataService().findbyGetCourier(
					courierNum,date));
		} catch (RemoteException e) {
		}
		return vos;
	}
	/**
	 * 更改货物到达状态
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setArrivalState(String listNum, GoodsArrivalState state) {
		try {
			GoodsVO vo = check(listNum);
			vo.arrivalState = state;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}catch(GoodsNotFound e1){
			return ResultMessage.NOT_FOUND;
		}
	}
	/**
	 * 更改物流状态
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setLogisticState(String listNum,
			GoodsLogisticState state) {
		try {
			GoodsVO vo = check(listNum);
			vo.logisticState = state;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}catch(GoodsNotFound e1){
			return ResultMessage.NOT_FOUND;
		}
	}
	/**
	 * 单据审批，ifPassed=true即审批通过   否则为不通过
	 * @param listNum
	 * @param ifPassed
	 * @return
	 */
	public ResultMessage examine(String listNum, Boolean ifPassed) {
		try {
			GoodsVO vo = check(listNum);
			vo.ifExaminePassed = ifPassed;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}catch(GoodsNotFound e1){
			return ResultMessage.NOT_FOUND;
		}
	}
	/**
	 * 收件信息录入 
	 * @param listNum
	 * @param realReceiverName
	 * @param realReceiverPhone可不填写 即传入null
	 * @return
	 */
	public ResultMessage end(String listNum, String realReceiverName,String realReceiverPhone) {
		try {
			System.out.println("Goodsbl.end "+listNum);
			GoodsVO vo = check(listNum);
			vo.realReceiverName = realReceiverName;
			vo.realReceiverPhone = realReceiverPhone;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}catch(GoodsNotFound e1){
			return ResultMessage.NOT_FOUND;
		}
	}
	/**
	 * 无需传参数，此方法自行从loginbl获取当前登录人的账号，返回快递员近日的业绩（即他经手的货物件数）
	 * 仅当月的业绩，若登录日期小于7号，则显示该月1号至当天的业绩，若大于7号，则显示近7天的业绩
	 * @return
	 */
	public int[] get7daysNumOfGoods(int numOfDays){
		int[] nums=new int[15];
		//initial
		for(int i=0;i<nums.length;i++) nums[i]=-1;
		String date = CurrentTime.getDate();
		for (int i = 0; i < numOfDays; i++) {
			nums[i] = getGoodsByCourier(Loginbl.getCurrentOptorId(), CurrentTime.minusDate(date, i));
		}
		return nums;
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

	/**
	 * 获得远程数据对象
	 * @return
	 */
	private GoodsDataService getGoodsDataService() {
		GoodsDataService data=null;
		try {
			data = (GoodsDataService)Naming.lookup("goodsServer");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}return data;
	}
	/**
	 * 
	 * @param courierNum
	 * @return返回快递员经手的所有货物的件数（包括收件和派件）
	 */
	private int getGoodsByCourier(String courierNum,String date) {
		int x=0;
		try {
			x=getGoodsDataService().findbyCourier(courierNum,date);
		} catch (RemoteException e) {
		}
		return x;
	}

}
