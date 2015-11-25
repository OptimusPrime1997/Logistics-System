package RMIClient;

import java.rmi.Naming;
import java.rmi.RemoteException;

import RMIservice.LogDataRemote;
import dataservice.logdataservice.LogDataService;

public class LogClient {
	LogDataRemote remote;

	public void getInstance() {
		try {
			remote = (LogDataRemote) Naming.lookup("rmi://127.0.0.1:109/log");
		} catch (Exception e) {
		}
	}

	public LogDataService getLogDataService() throws RemoteException {
		getInstance();
		return remote.getLogDataService();
	}
}
