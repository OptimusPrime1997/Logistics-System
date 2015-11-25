package dataservice.formdataservice;

import java.rmi.RemoteException;

import util.enumData.ResultMessage;
import PO.ProfitFormPO;

public interface ProfitFormDataService {
	public ResultMessage add(ProfitFormPO po)throws RemoteException;	
}
