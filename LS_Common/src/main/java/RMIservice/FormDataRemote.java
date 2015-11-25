package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;

public interface FormDataRemote extends Remote{
	public BusinessFormDataService getBusinessFormDataService()throws RemoteException;
	public ProfitFormDataService getProfitFormDataService()throws RemoteException;
}
