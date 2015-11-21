package ReceiptRMI;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.CashRepPO;
import PO.ReceiptPO;
import util.enumData.ResultMessage;

public class ReceiptServer extends UnicastRemoteObject implements ReceiptRemote{

	protected ReceiptServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
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
	
	@Override
	public ResultMessage submit(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashRepPO> getCashRepPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
