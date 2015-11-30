package dataservice.managementdataservice.accountdataservice;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import Exception.NumNotFoundException;
import util.enumData.ResultMessage;
import PO.AccountPO;

public interface AccountDataService {
	public ResultMessage insert(AccountPO po) throws IOException;

	public ResultMessage update(AccountPO po) throws RemoteException, ClassNotFoundException, IOException;

	public ResultMessage delete(AccountPO po) throws RemoteException, ClassNotFoundException, IOException;

	public ArrayList<AccountPO> show() throws RemoteException, ClassNotFoundException, IOException;

	public AccountPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException;

	public AccountPO findByAccountNum(String accountNum) throws RemoteException, FileNotFoundException, NameNotFoundException, NumNotFoundException, ClassNotFoundException, IOException;


	public ResultMessage logincheck(String accountNum, String key) throws RemoteException, FileNotFoundException, NumNotFoundException, ClassNotFoundException, IOException;

}
