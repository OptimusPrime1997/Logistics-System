/**
 * 
 */
package RMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import util.enumData.ResultMessage;
import PO.StockNumPO;
import RMIservice.StockNumDataRemote;
import dataimpl.stockdata.StockData;
import dataimpl.stockdata.StockInitialData;
import dataservice.stockdataservice.StockInitialDataService;

/**
 * @author G
 *
 */
public class StockInitialDataServer extends UnicastRemoteObject implements StockNumDataRemote {

	/**
	 * @throws RemoteException
	 */
	protected StockInitialDataServer() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public StockInitialDataService getStockNumData() throws RemoteException {
		return new StockInitialData();
	}

	public static void main(String[] args) {
		
		StockInitialDataService ds = new StockInitialData();
		try {
			LocateRegistry.createRegistry(233);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		Naming.rebind("stockinitial", ds);
		
	}

}
