package dataservice.formdataservice;

import java.rmi.RemoteException;

import PO.BusinessFormPO;

public interface BusinessFormDataService {

	public void add(BusinessFormPO po)throws RemoteException;
}
