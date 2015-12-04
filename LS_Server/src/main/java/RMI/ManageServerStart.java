package RMI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataimpl.management.managedata.ManageDataImpl;
import dataservice.managementdataservice.managedataservice.ManageDataService;

/**
 * 快速启动服务端 Created by Vboar on
 */
public class ManageServerStart {
	private static String getIpAddress() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		return address.getHostAddress();
	}

	public static void main(String[] args) {
		int port = ManageDataService.port;
		String ip = "";
		try {
			ip = getIpAddress();
			System.out.println("Server ip address:" + ip);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// 启动默认端口8888
			LocateRegistry.createRegistry(port);
			ManageDataImpl manageData = new ManageDataImpl();

			ip = "127.0.0.1";

			String name = ManageDataService.regname;
			Naming.rebind("rmi://" + ip + ":" + port + "/" + name, manageData);
			// new CheckItSelf();
			System.out.println("Server start");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}