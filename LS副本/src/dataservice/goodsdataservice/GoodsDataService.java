package dataservice.goodsdataservice;

import java.rmi.RemoteException;

import PO.GoodsPO;
/**
 * add/delete/modify/check the goods data
 * @author Administrator
 *
 */
public interface GoodsDataService {
	
	public void add(GoodsPO po)throws RemoteException;
	public void modify(GoodsPO po)throws RemoteException;
	public void delete(GoodsPO po)throws RemoteException;
	public void show()throws RemoteException;

}
