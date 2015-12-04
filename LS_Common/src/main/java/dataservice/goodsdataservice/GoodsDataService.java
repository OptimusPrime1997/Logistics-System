package dataservice.goodsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.CourierNotFoundException;
import Exception.GoodsNotFound;
import PO.GoodsPO;
/**
 * add/delete/modify/check the goods data
 * @author Administrator
 *
 */
public interface GoodsDataService extends Remote {
	
	public ResultMessage add(GoodsPO po)throws RemoteException;
	public ResultMessage modify(GoodsPO po)throws RemoteException;
	public ResultMessage delete(GoodsPO po)throws RemoteException, GoodsNotFound;
	public ArrayList<GoodsPO> show()throws RemoteException;
	public GoodsPO findbygoods(String ListNum)throws RemoteException, GoodsNotFound;
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum,String date)throws RemoteException;
	public int findbyCourier(String CourierNum,String date)throws RemoteException;

}
