package dataservice.managementdataservice.bankaccountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BankAccountPO;

public interface BankAccountDataService {
	public void insert(BankAccountPO po) throws RemoteException;

	public void update(BankAccountPO po) throws RemoteException;

	public void delete(BankAccountPO po) throws RemoteException;

	public ArrayList<BankAccountPO> show() throws RemoteException;

	public BankAccountPO findByName(String name) throws RemoteException;

	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException;
}
