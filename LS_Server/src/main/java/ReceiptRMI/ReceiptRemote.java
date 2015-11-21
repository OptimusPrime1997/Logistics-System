package ReceiptRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import PO.*;
import util.enumData.ResultMessage;

public interface ReceiptRemote extends Remote{
	public ResultMessage submit(ReceiptPO po) throws RemoteException;
	
	public ArrayList<CashRepPO> getCashRepPO() throws RemoteException;
}
