package dataservice.formdataservice;

import java.rmi.RemoteException;

import util.enumData.ResultMessage;
import PO.BusinessFormPO;

public interface BusinessFormDataService {

	public ResultMessage add(BusinessFormPO po)throws RemoteException;
}
