/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
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
	public ResultMessage add(StockPO po)throws RemoteException;
	
	/**
	 * delete by listnum
	 * @param listnum
	 * @throws RemoteException
	 */
	public ResultMessage delete(String listnum)throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockPO> getStock() throws RemoteException;
	
	
	
	
	
}
