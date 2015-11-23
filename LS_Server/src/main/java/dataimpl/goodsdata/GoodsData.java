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
	public ArrayList<GoodsVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsVO findbygoods(String ListNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsVO> findbyGetCourier(String CourierNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsVO> findbyCourier(String CourierNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
