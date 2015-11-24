package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import VO.GoodsVO;
import dataservice.goodsdataservice.GoodsDataService;

public class Goodsbl {
	GoodsDataService goodsData=DataFactory.getGoodsdata();
	
	public GoodsVO check(String listNum) {
		GoodsVO vo=null;
		try {
			vo=new GoodsVO(goodsData.findbygoods(listNum));
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return vo;
		
	}

	public GoodsVO init(GoodsVO vo) {
		MockConstBL ConstBL = new MockConstBL();
		//TODO the parameter of the findByConstName function is to be modified
		try {
			//TODO 计算运费
			double basicprice=ConstBL.findByConstName("").priceConst;
			double distance=ConstBL.findByConstName("").distanceConst;
			vo.moneyFare=basicprice*distance;//TODO公式先随便写一下
			vo.moneyTotal=vo.moneyFare+vo.moneyOfPackage;
		    goodsData.add(GoodsVO.toPO(vo));
			
		} catch (RemoteException e) {
		}
		return vo;
	}

	
	public Boolean delete(GoodsVO vo) {
		try {
			goodsData.delete(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<GoodsVO> getGoodsByCourier(String courierNum) {
		ArrayList<GoodsVO> vos=null;
		try {
			vos=GoodsVO.toVOArray(goodsData.findbyCourier(courierNum));
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return  vos;
	}
	public ArrayList<GoodsVO> getGoodsByGetCourier(String courierNum) {
		ArrayList<GoodsVO> vos=null;
		try {
			vos=GoodsVO.toVOArray(goodsData.findbyGetCourier(courierNum));
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return  vos;
	}
	
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		try {
			GoodsVO vo=check(listNum);
			vo.arrivalState=state;
			goodsData.modify(vo.toPO(vo));
		} catch (RemoteException e) {
		}
		return true;
	}

	
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		try {
			GoodsVO vo=check(listNum);
			vo.logisticState=state;
			goodsData.modify(vo.toPO(vo));
		} catch (RemoteException e) {
			
		}
		
		return true;
	}

	
	public void examine(String listNum, Boolean ifPassed) {
		try {
			GoodsVO vo=check(listNum);
			vo.ifExaminePassed=ifPassed;
			goodsData.modify(vo.toPO(vo));
		} catch (RemoteException e) {
			
		}
	}


	

}
