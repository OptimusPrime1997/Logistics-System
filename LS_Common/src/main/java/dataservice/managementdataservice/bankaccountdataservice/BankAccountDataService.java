package dataservice.managementdataservice.bankaccountdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.BankAccountPO;
import PO.ConstPO;

public interface BankAccountDataService extends Remote {
	public ResultMessage insert(BankAccountPO po) throws RemoteException,
			IOException;

	public ResultMessage update(BankAccountPO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ResultMessage delete(BankAccountPO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ArrayList<BankAccountPO> show() throws RemoteException,
			ClassNotFoundException, IOException;

	public BankAccountPO findByName(String name) throws RemoteException,
			FileNotFoundException, NameNotFoundException,
			ClassNotFoundException, IOException;

	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException, FileNotFoundException,
			NumNotFoundException, ClassNotFoundException, IOException;
}
