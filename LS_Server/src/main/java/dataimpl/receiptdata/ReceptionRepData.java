package dataimpl.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.receiptdataservice.ReceptionRepDataService;

public class ReceptionRepData extends UnicastRemoteObject implements ReceptionRepDataService{

	public ReceptionRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8195469100559143725L;

}
