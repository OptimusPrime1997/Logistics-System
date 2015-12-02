/**
 * 
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.stockdata.StockInitialData;
import dataservice.stockdataservice.StockInitialDataService;

/**
 * @author G
 *
 */
public class StockIniServer {

	public static void main(String[] args) {
		try {
			StockInitialDataService sn = new StockInitialData();

			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/stockini", sn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
