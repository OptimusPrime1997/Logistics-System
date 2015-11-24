package dataimpl.management.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.AccountPO;
import dataservice.managementdataservice.accountdataservice.AccountDataService;

public class AccountData implements AccountDataService{

	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPO findByAccountNum(String accountNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateAuthority(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateMsg(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginCheck(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultMessage logincheck(String name, String key)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
