/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.StockDivisionPO;
import PO.StockPO;

/**
 * @author G
 *
 */
public interface StockDataService {
	
	/**
	 * add stockPO to stockData
	 * @param po
	 * @throws RemoteException
	 */
	public void add(StockPO po)throws RemoteException;
	
	
	
	/**
	 * initial initialNum
	 * @param initialNum
	 * @throws RemoteException
	 */
	public void initial(int initialNum)throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public int getPresentQuantity() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockPO> show() throws RemoteException;
	
	
	/**
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public String findInStockNumByDivision (StockDivisionPO po) throws RemoteException;
	
	
}
