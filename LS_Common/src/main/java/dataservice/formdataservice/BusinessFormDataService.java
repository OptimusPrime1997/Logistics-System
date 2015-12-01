package dataservice.formdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import util.enumData.ResultMessage;
import PO.BusinessFormPO;

public interface BusinessFormDataService extends Remote {

	public ResultMessage add(BusinessFormPO po)throws RemoteException;
}
