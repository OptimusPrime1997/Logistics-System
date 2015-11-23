package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import dataimpl.receiptdata.*;
import dataservice.receiptdataservice.*;
import RMIservice.*;

public class ReceiptDataServer extends UnicastRemoteObject implements ReceiptDataRemote{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ReceiptDataServer() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		try{
			//注册表创建，启动registry,1099为默认端口
			LocateRegistry.createRegistry(1099);
			ReceiptDataRemote service = new ReceiptDataServer();
			Naming.rebind("cherb", service);
			System.out.println("Server is ready");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public CashRepDataService getCashRepDataService() {
		// TODO Auto-generated method stub
		return new CashRepData();
	}

	@Override
	public DeliverRepDataService getDeliverRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new DeliverRepData();
	}

	@Override
	public GetRepDataService getGetRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new GetRepData();
	}

	@Override
	public InStockRepDataService getInStockRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new InStockRepData();
	}

	@Override
	public OutStockRepDataService getOutStockRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new OutStackRepData();
	}

	@Override
	public PayRepDataService getPayRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new PayRepData();
	}

	@Override
	public ReceptionRepDataService getReceptionRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new ReceptionRepData();
	}

	@Override
	public ShipmentRepDataService getShipmentRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new ShipmentRepData();
	}

	@Override
	public ShippingRepDataService getShippingRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new ShippingRepData();
	}

	@Override
	public TransferRepDataService getTransferRepDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return new TransferRepData();
	}

}
