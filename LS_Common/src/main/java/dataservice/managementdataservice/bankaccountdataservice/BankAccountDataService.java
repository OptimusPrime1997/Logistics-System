package dataservice.managementdataservice.bankaccountdataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.BankAccountPO;

public interface BankAccountDataService {
	public ResultMessage insert(BankAccountPO po) throws RemoteException;

	public ResultMessage update(BankAccountPO po) throws RemoteException;

	public ResultMessage delete(BankAccountPO po) throws RemoteException;

	public ArrayList<BankAccountPO> show() throws RemoteException;

	public BankAccountPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException;

	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException, FileNotFoundException, NumNotFoundException;
}
