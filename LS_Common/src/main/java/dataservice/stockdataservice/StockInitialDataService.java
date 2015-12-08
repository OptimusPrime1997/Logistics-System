/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.StockNumPO;
import util.enumData.City;
import util.enumData.ResultMessage;

/**
 * @author G
 *
 */
public interface StockInitialDataService extends Remote{
	
	/**
	 * initial initialNum
	 * @param initialNum
	 * @throws RemoteException
	 */
	public ResultMessage initial(StockNumPO po)throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public StockNumPO getInitialNum(City citynum)throws RemoteException;
	

}
