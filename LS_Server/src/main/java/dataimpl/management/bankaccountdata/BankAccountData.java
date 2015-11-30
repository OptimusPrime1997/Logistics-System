package dataimpl.management.bankaccountdata;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.BankAccountPO;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import datautil.DataUtility;

public class BankAccountData extends UnicastRemoteObject implements
		BankAccountDataService {
	private static final long serialVersionUID = 1L;

	private final String path = "data/currentdata/bankaccount";
	private DataUtility d;

	/**
	 * 
	 */
	public BankAccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	@Override
	public ResultMessage insert(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if (d.save(po, path) == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			BankAccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (BankAccountPO) objects.get(i);
				if (p.getBankAccountNum().equals(po.getBankAccountNum())) {
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
	public ResultMessage delete(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			BankAccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (BankAccountPO) objects.get(i);
				if (p.getBankAccountNum().equals(po.getBankAccountNum())) {
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
	public ArrayList<BankAccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<BankAccountPO> BankAccountPOs = new ArrayList<BankAccountPO>();
		for (Object o : objects) {
			BankAccountPOs.add((BankAccountPO) o);
		}
		return BankAccountPOs;
	}

	@Override
	public BankAccountPO findByName(String name) throws RemoteException, FileNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		print();
		BankAccountPO exist=null;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			throw new FileNotFoundException();
		}else{
			BankAccountPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(BankAccountPO)objects.get(i);
				if(p.getBankAccountName().equals(name)){
					exist=p;
					break;
				}
			}
		}
		if(exist==null){
			throw new NameNotFoundException();
		}else{
			return exist;
		}
	
	}

	@Override
	public BankAccountPO findByBankAccountNum(String bankAccountNum)
			throws RemoteException, FileNotFoundException, NumNotFoundException {
		// TODO Auto-generated method stub
		print();
		BankAccountPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			BankAccountPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (BankAccountPO) objects.get(i);
				if (p.getBankAccountNum().equals(bankAccountNum)) {
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

	private void print() {
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getClassName()
				+ ": executing "
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}
