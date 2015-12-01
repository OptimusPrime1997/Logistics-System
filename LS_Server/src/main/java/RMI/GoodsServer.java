package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.goodsdata.GoodsData;
import dataimpl.stockdata.StockInitialData;
import dataservice.goodsdataservice.GoodsDataService;

public class GoodsServer {
public static void main(String[] args) {
	try {
		GoodsDataService goods = new GoodsData();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099/goodsServer", goods);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
