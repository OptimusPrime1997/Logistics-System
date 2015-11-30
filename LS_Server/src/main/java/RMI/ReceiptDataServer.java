package RMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import dataimpl.receiptdata.*;
import dataservice.receiptdataservice.*;

public class ReceiptDataServer extends UnicastRemoteObject implements Remote{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ReceiptDataServer() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		try{
			//注册表创建，启动registry,1099为默认端口
			LocateRegistry.createRegistry(1024);
			ReceiptDataService service = new ReceiptData();
			Naming.rebind("rmi://localhost:1024/receipt", service);
			System.out.println("Server is ready");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
