package dataservice.managementdataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.AccountPO;

public interface AccountDataService {
	public ResultMessage insert(AccountPO po) throws RemoteException;

	public ResultMessage update(AccountPO po) throws RemoteException;

	public ResultMessage delete(AccountPO po) throws RemoteException;

	public ArrayList<AccountPO> show() throws RemoteException;

	public AccountPO findByName(String name) throws RemoteException;

	public AccountPO findByAccountNum(String accountNum) throws RemoteException;

	public ResultMessage updateAuthority(AccountPO po) throws RemoteException;

	public ResultMessage updateMsg(AccountPO po) throws RemoteException;

	public boolean loginCheck(AccountPO po) throws RemoteException;

	public ResultMessage logincheck(String name, String key) throws RemoteException;

}
