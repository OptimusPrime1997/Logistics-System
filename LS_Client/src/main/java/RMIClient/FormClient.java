package RMIClient;

import java.rmi.RemoteException;

import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;

public class FormClient {
	public void getInstance(){
		//TODO
	}
	
	public BusinessFormDataService getBusinessFormDataService() throws RemoteException{
		getInstance();
		return null;
	}
	public ProfitFormDataService getProfitFormDataService() throws RemoteException{
		getInstance();
		return null;
	}
	
}
