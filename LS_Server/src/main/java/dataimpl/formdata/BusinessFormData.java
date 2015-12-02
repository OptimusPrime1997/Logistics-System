package dataimpl.formdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import util.enumData.ResultMessage;
import PO.BusinessFormPO;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormData extends UnicastRemoteObject implements BusinessFormDataService{

	public BusinessFormData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage add(BusinessFormPO po) throws RemoteException {
		return null;
	}

}
