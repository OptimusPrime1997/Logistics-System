package dataimpl.goodsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.GoodsPO;
import dataservice.goodsdataservice.GoodsDataService;
import datautil.DataUtility;

public class GoodsData extends UnicastRemoteObject implements GoodsDataService{
	String filename = "goods.txt";
	DataUtility du = new DataUtility();
	public  GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public GoodsPO findbygoods(String ListNum)throws RemoteException {
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
		return 0;
	}

}
