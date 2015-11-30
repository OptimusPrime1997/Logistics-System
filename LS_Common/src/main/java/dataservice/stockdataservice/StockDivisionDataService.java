/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.InStockRepPO;
import PO.OutStockRepPO;
import PO.StockDivisionPO;


/**
 * @author G
 *
 */
public interface StockDivisionDataService extends Remote{
	
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public ResultMessage initial() throws RemoteException;
	
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
	
	
	
	
}
