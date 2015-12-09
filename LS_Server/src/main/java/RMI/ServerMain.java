package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.formdata.BusinessFormData;
import dataimpl.formdata.ProfitFormData;
import dataimpl.goodsdata.GoodsData;
import dataimpl.logdata.LogData;
import dataimpl.management.managedata.ManageDataImpl;
import dataimpl.receiptdata.ReceiptData;
import dataimpl.stockdata.StockData;
import dataimpl.stockdata.StockDivisionData;
import dataimpl.stockdata.StockInitialData;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;
import dataservice.goodsdataservice.GoodsDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;
import dataservice.stockdataservice.StockInitialDataService;

public class ServerMain {
	public static void main(String[] args) {
		try {
			BusinessFormDataService business = new BusinessFormData();
			LocateRegistry.createRegistry(3331);
			Naming.rebind("rmi://localhost:3331/business", business);
			System.out.println("1");
			GoodsDataService goods = new GoodsData();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/goodsServer", goods);
			System.out.println("2");

			LogDataService log = new LogData();
			LocateRegistry.createRegistry(8888);
			Naming.rebind("rmi://localhost:8888/log", log);
			System.out.println("3");

			ProfitFormDataService profit = new ProfitFormData();
			LocateRegistry.createRegistry(3666);
			Naming.rebind("rmi://localhost:3666/profit", profit);
			System.out.println("4");

			LocateRegistry.createRegistry(1024);
			ReceiptDataService service = new ReceiptData();
			Naming.rebind("rmi://localhost:1024/receipt", service);
			System.out.println("5");

			StockInitialDataService sn = new StockInitialData();
			LocateRegistry.createRegistry(1111);
			Naming.rebind("rmi://localhost:1111/stockini", sn);
			System.out.println("6");

			StockDataService sd = new StockData();
			LocateRegistry.createRegistry(8099);
			Naming.rebind("rmi://localhost:8099/stock", sd);
			System.out.println("7");


			int port = ManageDataService.port;
			String ip = "";
			// 启动默认端口9999
			LocateRegistry.createRegistry(port);
			ManageDataImpl manageData = new ManageDataImpl();
			ip = "127.0.0.1";
			String name = ManageDataService.regname;
			Naming.rebind("rmi://" + ip + ":" + port + "/" + name, manageData);
			System.out.println("8");
			
			StockDivisionDataService sdd = new StockDivisionData();
			LocateRegistry.createRegistry(2056);
			Naming.rebind("rmi://localhost:2056/stockDivision", sdd);
			System.out.println("9");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
