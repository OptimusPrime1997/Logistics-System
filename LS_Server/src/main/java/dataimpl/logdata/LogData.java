package dataimpl.logdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
import dataservice.logdataservice.LogDataService;

public class LogData extends UnicastRemoteObject implements LogDataService{

	public LogData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
