/**
 * 
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.stockdata.StockData;
import dataservice.stockdataservice.StockDataService;

/**
 * @author G
 *
 */
public class StockServer {
	
	
	public static void main(String[] args) {
		try {
			StockDataService sd = new StockData();

			LocateRegistry.createRegistry(8099);
			Naming.rebind("rmi://localhost:8099/stock", sd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
