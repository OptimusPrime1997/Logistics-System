package dataimpl.formdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import util.enumData.ResultMessage;
import PO.ProfitFormPO;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormData extends UnicastRemoteObject implements ProfitFormDataService{

	public ProfitFormData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage add(ProfitFormPO po) throws RemoteException {
		// TODO 
		return null;
		
	}

}
