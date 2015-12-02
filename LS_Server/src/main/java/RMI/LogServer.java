package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.logdata.LogData;
import dataservice.logdataservice.LogDataService;

public class LogServer {
	public static void main(String[] args) {
		try {
			LogDataService log = new LogData();
			LocateRegistry.createRegistry(1130);
			Naming.rebind("rmi://localhost:1130/logServer", log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
