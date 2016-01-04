package RMIClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bl.loginbl.Loginbl;
import dataservice.receiptdataservice.*;

public class ReceiptClient {
	
	final public static String ip = Loginbl.getIP();
	private static ReceiptDataService service = null;
	private static PayRepDataService payService = null;
	private static InStockRepDataService inStockService = null;
	private static OutStockRepDataService outStockService = null;
	private static CashRepDataService cashRepDataService = null;
	private static TransferRepDataService transferRepDataService = null;
	
	public ReceiptDataService getReceiptDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(service==null)
			service = (ReceiptDataService)Naming.lookup("rmi://" + ip + ":1024/receipt"); 
		return service;
	}
	
	public PayRepDataService getPayRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(payService==null)
			payService = (PayRepDataService)Naming.lookup("rmi://" + ip + ":1025/pay");
		return payService;
	}
	
	public InStockRepDataService getInStockRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(inStockService==null)
			inStockService = (InStockRepDataService)Naming.lookup("rmi://" + ip + ":1026/inStock");
		return inStockService;
	}
	
	public OutStockRepDataService getOutStockRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(outStockService==null)
			outStockService = (OutStockRepDataService)Naming.lookup("rmi://" + ip + ":1027/outStock");
		return outStockService;
	}
	public CashRepDataService getCashRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(cashRepDataService==null)
			cashRepDataService = (CashRepDataService)Naming.lookup("rmi://" + ip + ":1028/cash");
		return cashRepDataService;
	}
	
	public TransferRepDataService getTransferRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(transferRepDataService==null)
			transferRepDataService = (TransferRepDataService)Naming.lookup("rmi://" + ip + ":1029/transfer");
		return transferRepDataService;
	}
}