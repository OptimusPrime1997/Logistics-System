package dataimpl.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.receiptdataservice.GetRepDataService;

public class GetRepData extends UnicastRemoteObject implements GetRepDataService{

	public GetRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056284539771419528L;
	

}
