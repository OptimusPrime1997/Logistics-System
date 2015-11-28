/**
 * 
 */
package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.stockdataservice.StockDataService;

/**
 * @author G
 *
 */
public interface StockDataRemote extends Remote{
	public StockDataService getStockData() throws RemoteException;
}
