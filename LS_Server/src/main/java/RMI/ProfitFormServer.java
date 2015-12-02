package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataimpl.formdata.ProfitFormData;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormServer {
public static void main(String[] args) {
	try {
		ProfitFormDataService data=new ProfitFormData();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("rmi://localhost:1099/profit",data);
	} catch (Exception e) {
	}
}
}
