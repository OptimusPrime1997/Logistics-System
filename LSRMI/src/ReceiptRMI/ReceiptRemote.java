package ReceiptRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReceiptRemote extends Remote{
	public String getCourier() throws RemoteException;
}
