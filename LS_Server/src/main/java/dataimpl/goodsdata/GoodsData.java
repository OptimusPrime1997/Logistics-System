package dataimpl.goodsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GoodsPO;
import dataservice.goodsdataservice.GoodsDataService;

public class GoodsData implements GoodsDataService{

	@Override
	public void add(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GoodsPO po) throws RemoteException {
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
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsPO> findbyCourier(String CourierNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
