package dataimpl.management.accountdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.AccountPO;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import datautil.DataUtility;

public class AccountData extends UnicastRemoteObject implements
		AccountDataService {
	private final String path = "data/currentdata/account";
	private DataUtility d;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	@Override
	public ResultMessage insert(AccountPO po) throws IOException {
		// TODO Auto-generated method stub
		print();
		if (d.save(po, path) == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(AccountPO po) throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			AccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (AccountPO) objects.get(i);
				if (p.getAccountNum().equals(po.getAccountNum())) {
					objects.remove((Object) p);
					objects.add((Object) po);
					findPO = true;
					d.SaveAll(objects, path);
					break;
				}
			}
		}
		if (findPO == true) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.NOT_FOUND;
		}
	}

	@Override
	public ResultMessage delete(AccountPO po) throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			AccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (AccountPO) objects.get(i);
				if (p.getAccountNum().equals(po.getAccountNum())) {
					findPO = true;
					objects.remove((Object) p);
				}
				break;
			}
			d.SaveAll(objects, path);
		}
		if (findPO == true) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.NOT_FOUND;
		}
	}

	@Override
	public ArrayList<AccountPO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<AccountPO> accountPOs = new ArrayList<AccountPO>();
		for (Object o : objects) {
			accountPOs.add((AccountPO) o);
		}
		return accountPOs;
	}

	@Override
	public AccountPO findByName(String name) throws NameNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		AccountPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			AccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (AccountPO) objects.get(i);
				if (p.getAccountName().equals(name)) {
					exist = p;
					break;
				}
			}
		}
		if (exist == null) {
			throw new NameNotFoundException();
		} else {
			return exist;
		}
	}

	@Override
	public AccountPO findByAccountNum(String accountNum)
			throws NumNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		AccountPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			AccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (AccountPO) objects.get(i);
				if (p.getAccountNum().equals(accountNum)) {
					exist = p;
					break;
				}
			}
		}
		if (exist == null) {
			throw new NumNotFoundException();
		} else {
			return exist;
		}
	}

	@Override
	public ResultMessage logincheck(String accountNum, String key)
			throws NumNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		AccountPO accountPO = findByAccountNum(accountNum);
		if (accountPO.getPassword().equals(key)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAILED;
		}
	}

	private void print() {
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getClassName()
				+ ": executing "
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}
