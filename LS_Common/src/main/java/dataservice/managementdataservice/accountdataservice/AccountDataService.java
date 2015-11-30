package dataservice.managementdataservice.accountdataservice;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import Exception.NumNotFoundException;
import util.enumData.ResultMessage;
<<<<<<< HEAD
=======
import Exception.NumNotFoundException;
>>>>>>> origin/master
import PO.AccountPO;

public interface AccountDataService {
	public ResultMessage insert(AccountPO po) throws IOException;

	public ResultMessage update(AccountPO po) throws RemoteException;

	public ResultMessage delete(AccountPO po) throws RemoteException;

	public ArrayList<AccountPO> show() throws RemoteException;

	public AccountPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException;

	public AccountPO findByAccountNum(String accountNum) throws RemoteException, FileNotFoundException, NameNotFoundException;


	public ResultMessage logincheck(String accountNum, String key) throws RemoteException, FileNotFoundException, NumNotFoundException;

}
