package dataimpl.goodsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.GoodsPO;
import dataservice.goodsdataservice.GoodsDataService;

public class GoodsData implements GoodsDataService{

	@Override
	public ResultMessage add(GoodsPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modify(GoodsPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<GoodsPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsPO findbygoods(String ListNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum,String date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findbyCourier(String CourierNum,String date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
