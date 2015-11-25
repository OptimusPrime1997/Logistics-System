package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
/**
 * add or check the system log
 * @author Administrator
 *
 */
public interface LogDataService {
	public ArrayList<LogPO> show(LogType type,String startTime,String endTime)throws RemoteException;
	public ResultMessage add(LogPO po)throws RemoteException;
}
