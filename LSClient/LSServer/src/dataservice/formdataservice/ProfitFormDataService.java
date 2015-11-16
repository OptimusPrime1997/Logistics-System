package dataservice.formdataservice;

import java.rmi.RemoteException;
import PO.ProfitFormPO;

public interface ProfitFormDataService {
	public void add(ProfitFormPO po)throws RemoteException;	
}
