package dataimpl.formdata;

import java.rmi.RemoteException;

import util.enumData.ResultMessage;
import PO.BusinessFormPO;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormData implements BusinessFormDataService{

	@Override
	public ResultMessage add(BusinessFormPO po) throws RemoteException {
		return null;
	}

}
