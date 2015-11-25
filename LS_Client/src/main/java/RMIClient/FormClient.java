package RMIClient;

import java.rmi.Naming;
import java.rmi.RemoteException;

import RMIservice.FormDataRemote;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;

public class FormClient {
	FormDataRemote remote;
	public void getInstance(){
		try{
			remote=(FormDataRemote)Naming.lookup("rmi://127.0.0.1:5015/form");
		}catch(Exception e){
			
		}
	}
	public BusinessFormDataService getBusinessFormDataService() throws RemoteException{
		getInstance();
		return remote.getBusinessFormDataService();
	}
	public ProfitFormDataService getProfitFormDataService() throws RemoteException{
		getInstance();
		return remote.getProfitFormDataService();
	}
	
}
