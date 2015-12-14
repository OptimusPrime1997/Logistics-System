package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.formdata.BusinessFormData;
import dataimpl.formdata.ProfitFormData;
import dataimpl.goodsdata.GoodsData;
import dataimpl.logdata.LogData;
import dataimpl.management.managedata.ManageDataImpl;
import dataimpl.receiptdata.PayRepData;
import dataimpl.receiptdata.ReceiptData;
import dataimpl.stockdata.StockData;
import dataimpl.stockdata.StockDivisionData;
import dataimpl.stockdata.StockInitialData;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;
import dataservice.goodsdataservice.GoodsDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.receiptdataservice.PayRepDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;
import dataservice.stockdataservice.StockInitialDataService;

public class ServerMain {
	final public static String ip = "127.0.0.1";
	final static int defaultPort = 1099;

	public static void main(String[] args) {
		try {
			BusinessFormDataService business = new BusinessFormData();
			LocateRegistry.createRegistry(3331);
			Naming.rebind("rmi://" + ip + ":" + "3331/business", business);
			System.out.println("1");

			GoodsDataService goods = new GoodsData();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://" + ip + ":" + defaultPort + "/goodsServer",
					goods);
			System.out.println("2");

			LogDataService log = new LogData();
			Naming.rebind("rmi://" + ip + ":" + defaultPort + "/log", log);
			System.out.println("3");

			ProfitFormDataService profit = new ProfitFormData();
			LocateRegistry.createRegistry(3666);
			Naming.rebind("rmi://" + ip + ":" + "3666/profit", profit);
			System.out.println("4");

			LocateRegistry.createRegistry(1024);
			ReceiptDataService service = new ReceiptData();
			Naming.rebind("rmi://" + ip + ":" + "1024/receipt", service);
			System.out.println("5");

			StockInitialDataService sn = new StockInitialData();
			Naming.rebind("rmi://" + ip + ":" + defaultPort + "/stockini", sn);
			System.out.println("6");

			StockDataService sd = new StockData();
			Naming.rebind("rmi://" + ip + ":" + defaultPort + "/stock", sd);
			System.out.println("7");

			int port = ManageDataService.port;
			// 启动默认端口9999
			LocateRegistry.createRegistry(port);
			ManageDataImpl manageData = new ManageDataImpl();
			String name = ManageDataService.regname;
			Naming.rebind("rmi://" + ip + ":" + port + "/" + name, manageData);
			System.out.println("8");

			StockDivisionDataService sdd = new StockDivisionData();
			Naming.rebind("rmi://" + ip + ":" + defaultPort + "/stockDivision",
					sdd);
			System.out.println("9");
			
			LocateRegistry.createRegistry(1025);
			PayRepDataService payService = new PayRepData();
			Naming.rebind("rmi://" + ip + ":" + "1025/payRep", payService);
			System.out.println("10");
			
			LocateRegistry.createRegistry(1026);
			PayRepDataService inStockService = new PayRepData();
			Naming.rebind("rmi://" + ip + ":" + "1026/inStock", inStockService);
			System.out.println("11");
			
			LocateRegistry.createRegistry(1027);
			PayRepDataService outStockService = new PayRepData();
			Naming.rebind("rmi://" + ip + ":" + "1027/outStock", outStockService);
			System.out.println("12");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
