package dataimpl.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.receiptdataservice.ShippingRepDataService;

public class ShippingRepData extends UnicastRemoteObject implements ShippingRepDataService{

	public ShippingRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9001248180757354972L;

}
