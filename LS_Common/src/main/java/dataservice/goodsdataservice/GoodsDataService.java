package dataservice.goodsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.GoodsPO;
/**
 * add/delete/modify/check the goods data
 * @author Administrator
 *
 */
public interface GoodsDataService {
	
	public ResultMessage add(GoodsPO po)throws RemoteException;
	public ResultMessage modify(GoodsPO po)throws RemoteException;
	public ResultMessage delete(GoodsPO po)throws RemoteException;
	public ArrayList<GoodsPO> show()throws RemoteException;
	public GoodsPO findbygoods(String ListNum)throws RemoteException;
	public ArrayList<GoodsPO> findbyGetCourier(String CourierNum)throws RemoteException;
	public ArrayList<GoodsPO> findbyCourier(String CourierNum)throws RemoteException;

}
