package RMIClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import dataservice.receiptdataservice.*;

public class ReceiptClient {
	
	private static ReceiptDataService service = null;
	private static PayRepDataService payService = null;
	private static InStockRepDataService inStockService = null;
	private static OutStockRepDataService outStockService = null;
	private static CashRepDataService cashRepDataService = null;
	
	public ReceiptDataService getReceiptDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(service==null)
			service = (ReceiptDataService)Naming.lookup("rmi://localhost:1024/receipt"); 
		return service;
	}
	
	public PayRepDataService getPayRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(payService==null)
			payService = (PayRepDataService)Naming.lookup("rmi://localhost:1025/pay");
		return payService;
	}
	
	public InStockRepDataService getInStockRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(inStockService==null)
			inStockService = (InStockRepDataService)Naming.lookup("rmi://localhost:1026/inStock");
		return inStockService;
	}
	
	public OutStockRepDataService getOutStockRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(outStockService==null)
			outStockService = (OutStockRepDataService)Naming.lookup("rmi://localhost:1027/outStock");
		return outStockService;
	}
	public CashRepDataService getCashRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(cashRepDataService==null)
			cashRepDataService = (CashRepDataService)Naming.lookup("rmi://localhost:1028/cash");
		return cashRepDataService;
	}
}