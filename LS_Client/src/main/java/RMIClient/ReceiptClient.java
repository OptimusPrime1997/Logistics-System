package RMIClient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import RMIservice.ReceiptDataRemote;
import dataservice.receiptdataservice.*;

public class ReceiptClient {
	
	private static ReceiptDataRemote service = null;
	
	public void getInstance(){
		try{
			if(service==null)
				service = (ReceiptDataRemote)Naming.lookup("rmi://127.0.0.1:1099/cherb"); 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public CashRepDataService getCashRepDataService() throws RemoteException{
		getInstance();
		CashRepDataService cashRepDataService =service.getCashRepDataService();
		return cashRepDataService;
	}
	
	public DeliverRepDataService getDeliverRepDataService() throws RemoteException{
		getInstance();
		DeliverRepDataService deliverRepDataService = service.getDeliverRepDataService();
		return deliverRepDataService;
	}
	
	public GetRepDataService getGetRepDataService() throws RemoteException{
		getInstance();
		GetRepDataService getRepDataService = service.getGetRepDataService();
		return getRepDataService;
	}
	
	public InStockRepDataService getInStockRepDataService() throws RemoteException{
		getInstance();
		InStockRepDataService inStockRepDataService = service.getInStockRepDataService();
		return inStockRepDataService;
	}
	
	public OutStockRepDataService getOutStockRepDataService() throws RemoteException{
		getInstance();
		OutStockRepDataService outStockRepDataService = service.getOutStockRepDataService();
		return outStockRepDataService;
	}
	
	public PayRepDataService getPayRepDataService() throws RemoteException{
		getInstance();
		PayRepDataService payRepDataService = service.getPayRepDataService();
		return payRepDataService;
	}
	
	public ReceptionRepDataService getReceptionRepDataService() throws RemoteException{
		getInstance();
		ReceptionRepDataService receptionRepDataService = service.getReceptionRepDataService();
		return receptionRepDataService;
	}
	
	public ShipmentRepDataService getShipmentRepDataService() throws RemoteException{
		getInstance();
		ShipmentRepDataService shipmentRepDataService = service.getShipmentRepDataService();
		return shipmentRepDataService;
	}
	
	public ShippingRepDataService getShippingRepDataService() throws RemoteException{
		getInstance();
		ShippingRepDataService shippingRepDataService = service.getShippingRepDataService();
		return shippingRepDataService;
	}
	
	public TransferRepDataService getTransferRepDataService() throws RemoteException{
		getInstance();
		TransferRepDataService transferRepDataService = service.getTransferRepDataService();
		return transferRepDataService;
	}
	
}