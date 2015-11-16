package dataservice.goodsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.GoodsPO;
import VO.GoodsVO;
/**
 * add/delete/modify/check the goods data
 * @author Administrator
 *
 */
public interface GoodsDataService {
	
	public void add(GoodsPO po)throws RemoteException;
	public void modify(GoodsPO po)throws RemoteException;
	public void delete(GoodsPO po)throws RemoteException;
	public ArrayList<GoodsVO> show()throws RemoteException;
	public GoodsVO findbygoods(String ListNum)throws RemoteException;
	public ArrayList<GoodsVO> findbyGetCourier(String CourierNum)throws RemoteException;
	public ArrayList<GoodsVO> findbyCourier(String CourierNum)throws RemoteException;

}
