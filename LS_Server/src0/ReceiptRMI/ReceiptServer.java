package ReceiptRMI;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ReceiptServer extends UnicastRemoteObject implements ReceiptRemote{

	protected ReceiptServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCourier() throws RemoteException {
		return "xixi";
	}

	public static void main(String[] args){
		try{
			//注册表创建，启动registry,1099为默认端口
			LocateRegistry.createRegistry(1099);
			ReceiptRemote service = new ReceiptServer();
			Naming.rebind("Hello", service);
			System.out.println("Server is ready");
		}
		catch(Exception ex){
			ex.printStackTrace();;
		}
	}
}
