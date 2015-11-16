package dataservice.managementdataservice.bankaccountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import PO.BankAccountPO;

public interface BankAccountDataService {
	public ResultMessage insert(BankAccountPO po) throws RemoteException;

	public ResultMessage update(BankAccountPO po) throws RemoteException;

	public ResultMessage delete(BankAccountPO po) throws RemoteException;

	public ArrayList<BankAccountPO> show() throws RemoteException;

	public BankAccountPO findByName(String name) throws RemoteException;

	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException;
}
