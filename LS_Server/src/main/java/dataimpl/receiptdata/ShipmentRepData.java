package dataimpl.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.receiptdataservice.ShipmentRepDataService;

public class ShipmentRepData extends UnicastRemoteObject implements ShipmentRepDataService{

	public ShipmentRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2154264162394765969L;


}
