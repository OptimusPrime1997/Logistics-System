package dataservice.managementdataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AccountPO;

public interface AccountDataService {
	public void insert(AccountPO po)throws RemoteException;
	public void update(AccountPO po)throws RemoteException;
	public void delete(AccountPO po)throws RemoteException;
	public ArrayList<AccountPO> show()throws RemoteException;
	public AccountPO findByName(String name)throws RemoteException;
	public AccountPO findByAccountNum(String accountNum)throws RemoteException;
	public void updateAuthority(AccountPO po)throws RemoteException;
	public void updateMsg(AccountPO po)throws RemoteException;
	public boolean loginCheck(AccountPO po)throws RemoteException;
	public void logincheck(String name,String key)throws RemoteException;

}
