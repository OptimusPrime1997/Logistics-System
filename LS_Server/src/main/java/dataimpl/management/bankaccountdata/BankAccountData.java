package dataimpl.management.bankaccountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.BankAccountPO;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;

public class BankAccountData implements BankAccountDataService {

	@Override
	public ResultMessage insert(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankAccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
