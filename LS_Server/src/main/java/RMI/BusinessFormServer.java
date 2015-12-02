package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataimpl.formdata.BusinessFormData;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormServer {
public static void main(String[] args) {
	try {
		BusinessFormDataService data=new BusinessFormData();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099/business", data);
	} catch (Exception e) {
		
	}
	
}
}
