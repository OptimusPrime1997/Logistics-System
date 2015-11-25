package dataimpl.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
import dataservice.logdataservice.LogDataService;

public class LogData implements LogDataService{

	@Override
	public ResultMessage add(LogPO po) throws RemoteException {
		return null;
		// TODO
		
	}

	@Override
	public ArrayList<LogPO> show(LogType type, String startTime, String endTime)
			throws RemoteException {
		// TODO 
		return null;
	}


}
