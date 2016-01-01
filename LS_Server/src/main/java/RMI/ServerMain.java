package RMI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


import dataimpl.formdata.BusinessFormData;
import dataimpl.formdata.ProfitFormData;
import dataimpl.goodsdata.GoodsData;
import dataimpl.logdata.LogData;
import dataimpl.management.managedata.ManageDataImpl;
import dataimpl.receiptdata.CashRepData;
import dataimpl.receiptdata.InStockRepData;
import dataimpl.receiptdata.OutStockRepData;
import dataimpl.receiptdata.PayRepData;
import dataimpl.receiptdata.ReceiptData;
import dataimpl.receiptdata.TransferRepData;
import dataimpl.stockdata.StockData;
import dataimpl.stockdata.StockDivisionData;
import dataimpl.stockdata.StockInitialData;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;
import dataservice.goodsdataservice.GoodsDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.receiptdataservice.CashRepDataService;
import dataservice.receiptdataservice.InStockRepDataService;
import dataservice.receiptdataservice.OutStockRepDataService;
import dataservice.receiptdataservice.PayRepDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import dataservice.receiptdataservice.TransferRepDataService;
import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;
import dataservice.stockdataservice.StockInitialDataService;

public class ServerMain {
	public static String ip = "127.0.0.1";
	final static int defaultPort = 1099;

	public static void setCurrentIP(){
		String currentIP = null;
		try {
			currentIP = InetAddress.getLocalHost().getHostAddress();
			System.out.println("当前服务器IP地址：" + currentIP);
			ip = currentIP;
			System.out.println("设置服务器地址为：" + ip);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			System.out.println("获取当前IP地址失败。");
			e1.printStackTrace();
		}
		if (currentIP != null) {
			 ip=currentIP;
		}
	}
	public static void startService() {
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
			Naming.rebind("rmi://" + ip + ":" + "1025/pay", payService);
			System.out.println("10");

			LocateRegistry.createRegistry(1026);
			InStockRepDataService inStockService = new InStockRepData();
			Naming.rebind("rmi://" + ip + ":" + "1026/inStock", inStockService);
			System.out.println("11");

			LocateRegistry.createRegistry(1027);
			OutStockRepDataService outStockService = new OutStockRepData();
			Naming.rebind("rmi://" + ip + ":" + "1027/outStock",
					outStockService);
			System.out.println("12");

			LocateRegistry.createRegistry(1028);
			CashRepDataService cashService = new CashRepData();
			Naming.rebind("rmi://" + ip + ":" + "1028/cash", cashService);
			System.out.println("13");

			LocateRegistry.createRegistry(1029);
			TransferRepDataService transferService = new TransferRepData();
			Naming.rebind("rmi://" + ip + ":" + "1029/transfer",
					transferService);
			System.out.println("14");
			System.out.println("服务器启动完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		startService();
	}
}
