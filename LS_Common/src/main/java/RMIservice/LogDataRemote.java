package RMIservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.logdataservice.LogDataService;

public interface LogDataRemote extends Remote{
	public LogDataService getLogDataService()throws RemoteException;

}
