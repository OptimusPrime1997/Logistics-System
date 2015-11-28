/**
 * 
 */
package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author G
 *
 */
public interface StockDivisionDataService extends Remote{
	public StockDivisionDataService getStockDivisionData() throws RemoteException;
}
