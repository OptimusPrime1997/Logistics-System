/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InStockRepPO;
import PO.OutStockRepPO;
import PO.StockDivisionPO;


/**
 * @author G
 *
 */
public interface StockDivisionDataService {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public int getInitialNum()throws RemoteException;
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public void initial() throws RemoteException;
	
	/**
	 * update stockData and stockDivisionData
	 * @param rep
	 * @throws RemoteException
	 */
	public void update(InStockRepPO po) throws RemoteException;
	
	public void update(OutStockRepPO po) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockDivisionPO> getStockDivision() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockDivisionPO> show() throws RemoteException;
	
	
	
}
