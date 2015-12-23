package dataimpl.receiptdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.receiptdataservice.DeliverRepDataService;

public class DeliverRepData extends UnicastRemoteObject  implements DeliverRepDataService{
	

	public DeliverRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2275152675148326991L;

}
