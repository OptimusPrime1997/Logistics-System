package dataservice.logdataservice;

import java.rmi.RemoteException;

import PO.LogPO;
/**
 * add or check the system log
 * @author Administrator
 *
 */
public interface LogDataService {
	public void show(String type)throws RemoteException;
	public void add(LogPO po)throws RemoteException;
}
