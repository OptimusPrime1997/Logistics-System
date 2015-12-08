package dataimpl.formdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import util.enumData.ResultMessage;
import PO.ProfitFormPO;
import dataservice.formdataservice.ProfitFormDataService;
import datautil.DataUtility;

public class ProfitFormData extends UnicastRemoteObject implements ProfitFormDataService{
	String filename = "profitForm.txt";
	DataUtility helper = new DataUtility();	
	public ProfitFormData() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage add(ProfitFormPO po) throws RemoteException {
		try {//TODO 还有导出excel没实现~~~~问天歌~~
			return helper.save(po, filename);
		} catch (IOException e) {
		}
		return ResultMessage.FAILED;
	}

}
