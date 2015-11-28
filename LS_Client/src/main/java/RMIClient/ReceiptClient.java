package RMIClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.omg.CORBA.PUBLIC_MEMBER;

import RMIservice.ReceiptDataRemote;
import dataservice.receiptdataservice.*;

public class ReceiptClient {
	
	private static ReceiptDataRemote service = null;
	
	public void getInstance() throws MalformedURLException, RemoteException, NotBoundException{
		if(service==null)
			service = (ReceiptDataRemote)Naming.lookup("rmi://127.0.0.1:1099/cherb"); 
	}
	
	public CashRepDataService getCashRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		CashRepDataService cashRepDataService =service.getCashRepDataService();
		return cashRepDataService;
	}
	
	public DeliverRepDataService getDeliverRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		DeliverRepDataService deliverRepDataService = service.getDeliverRepDataService();
		return deliverRepDataService;
	}
	
	public GetRepDataService getGetRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		GetRepDataService getRepDataService = service.getGetRepDataService();
		return getRepDataService;
	}
	
	public InStockRepDataService getInStockRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		InStockRepDataService inStockRepDataService = service.getInStockRepDataService();
		return inStockRepDataService;
	}
	
	public OutStockRepDataService getOutStockRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		OutStockRepDataService outStockRepDataService = service.getOutStockRepDataService();
		return outStockRepDataService;
	}
	
	public PayRepDataService getPayRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		PayRepDataService payRepDataService = service.getPayRepDataService();
		return payRepDataService;
	}
	
	public ReceptionRepDataService getReceptionRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		ReceptionRepDataService receptionRepDataService = service.getReceptionRepDataService();
		return receptionRepDataService;
	}
	
	public ShipmentRepDataService getShipmentRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		ShipmentRepDataService shipmentRepDataService = service.getShipmentRepDataService();
		return shipmentRepDataService;
	}
	
	public ShippingRepDataService getShippingRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		ShippingRepDataService shippingRepDataService = service.getShippingRepDataService();
		return shippingRepDataService;
	}
	
	public TransferRepDataService getTransferRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		TransferRepDataService transferRepDataService = service.getTransferRepDataService();
		return transferRepDataService;
	}
	
	public ReceiptDataService getReceiptDataService() throws RemoteException, MalformedURLException, NotBoundException{
		getInstance();
		ReceiptDataService receiptDataService = service.getReceiptDataService();
		return receiptDataService;
	}
	
}