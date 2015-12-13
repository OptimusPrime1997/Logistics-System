package RMIClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import dataservice.receiptdataservice.*;

public class ReceiptClient {
	
	private static ReceiptDataService service = null;
	private static PayRepDataService payService = null;
	
	public ReceiptDataService getReceiptDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(service==null)
			service = (ReceiptDataService)Naming.lookup("rmi://localhost:1024/receipt"); 
		return service;
	}
	
	public PayRepDataService getPayRepDataService() throws MalformedURLException, RemoteException, NotBoundException{
		if(payService==null)
			payService = (PayRepDataService)Naming.lookup("rmi://localhost:1025/payRep");
		return payService;
	}
}