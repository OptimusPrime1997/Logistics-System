package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.receiptdataservice.*;

public interface ReceiptDataRemote extends Remote{
	public CashRepDataService getCashRepDataService() throws RemoteException;
	
	public DeliverRepDataService getDeliverRepDataService() throws RemoteException;
	
	public GetRepDataService getGetRepDataService() throws RemoteException;
	
	public InStockRepDataService getInStockRepDataService() throws RemoteException;
	
	public OutStockRepDataService getOutStockRepDataService() throws RemoteException;
	
	public PayRepDataService getPayRepDataService() throws RemoteException;
	
	public ReceptionRepDataService getReceptionRepDataService() throws RemoteException;
	
	public ShipmentRepDataService getShipmentRepDataService() throws RemoteException;
	
	public ShippingRepDataService getShippingRepDataService() throws RemoteException;
	
	public TransferRepDataService getTransferRepDataService() throws RemoteException;
}
