package dataimpl.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import PO.LogPO;
import dataservice.logdataservice.LogDataService;

public class LogData implements LogDataService{

	@Override
	public void add(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<LogPO> show(LogType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
