package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.logbl.LogType;
import PO.LogPO;
/**
 * add or check the system log
 * @author Administrator
 *
 */
public interface LogDataService {
	public ArrayList<LogPO> show(LogType type)throws RemoteException;
	public void add(LogPO po)throws RemoteException;
}
