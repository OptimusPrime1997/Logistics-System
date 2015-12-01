package dataservice.formdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import util.enumData.ResultMessage;
import PO.ProfitFormPO;

public interface ProfitFormDataService extends Remote{
	public ResultMessage add(ProfitFormPO po)throws RemoteException;	
}
