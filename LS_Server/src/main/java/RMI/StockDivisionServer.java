/**
 * 
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.stockdata.StockDivisionData;
import dataservice.stockdataservice.StockDivisionDataService;

/**
 * @author G
 *
 */
public class StockDivisionServer {

	public static void main(String[] args) {
		try {
			StockDivisionDataService sd = new StockDivisionData();

			LocateRegistry.createRegistry(4099);
			Naming.rebind("rmi://localhost:4099/stockDivision", sd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
