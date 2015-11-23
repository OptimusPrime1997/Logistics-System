package dataimpl.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.logbl.LogType;
import PO.LogPO;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class LogData implements LogDataService{

	@Override
	public void add(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<LogVO> show(LogType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
