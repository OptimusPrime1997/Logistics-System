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
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void examine(String listNum, Boolean ifPassed) {
		// TODO Auto-generated method stub
		
	}

}
