package bl.goodsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.DataFactory;
import VO.GoodsVO;
import bl.managementbl.constbl.ConstBL;
import dataservice.goodsdataservice.GoodsDataService;

public class Goodsbl {
	GoodsDataService goodsData=DataFactory.getGoodsdata();
	ConstBL ConstBL = new ConstBL();
	
	public GoodsVO check(String listNum) {
		GoodsVO vo=null;
		try {
			vo=goodsData.findbygoods(listNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
	}

	
	public Boolean init(GoodsVO vo) {
		//TODO the parameter of the findByConstName function is to be modified
		try {
			//TODO 计算运费
			int basicprice=ConstBL.findByConstName("").priceConst;
			int distance=ConstBL.findByConstName("").distanceConst;
			vo.moneyFare=basicprice*distance;//TODO公式先随便写一下
			vo.moneyTotal=vo.moneyFare+vo.moneyOfPackage;
		    goodsData.add(vo.toPO(vo));
			
		} catch (RemoteException e) {
		}
		return true;
	}

	
	public Boolean delete(GoodsVO vo) {
		try {
			goodsData.delete(vo.toPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<GoodsVO> getGoodsByCourier(String courierNum) {
		ArrayList<GoodsVO> vos=null;
		try {
			vos=goodsData.findbyCourier(courierNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  vos;
	}
	public ArrayList<GoodsVO> getGoodsByGetCourier(String courierNum) {
		ArrayList<GoodsVO> vos=null;
		try {
			vos=goodsData.findbyGetCourier(courierNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		try {
			GoodsVO vo=check(listNum);
			vo.logisticState=state;
			goodsData.modify(vo.toPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	
	public void examine(String listNum, Boolean ifPassed) {
		try {
			GoodsVO vo=check(listNum);
			vo.ifExaminePassed=ifPassed;
			goodsData.modify(vo.toPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
