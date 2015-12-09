package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.logdata.LogData;
import dataservice.logdataservice.LogDataService;

public class LogServer {
	public static void main(String[] args) {
		try {
			LogDataService log = new LogData();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/logServer", log);
			System.out.println("LogServer's ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
