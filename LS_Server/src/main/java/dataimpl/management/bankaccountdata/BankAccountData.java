package dataimpl.management.bankaccountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.AccountPO;
import PO.BankAccountPO;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import datautil.DataUtility;

public class BankAccountData extends UnicastRemoteObject implements BankAccountDataService {
	private static final long serialVersionUID = 1L;

	private String path="data/currentdata/bankaccount/bankaccount";
	private DataUtility d;
	/**
	 * 
	 */
	public BankAccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		 d=new DataUtility();
	}

	
	@Override
	public ResultMessage insert(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(d.save(po,path)==ResultMessage.FAILED){
			return ResultMessage.FAILED;
		}else{
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			BankAccountPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(BankAccountPO)objects.get(i);
				if(p.getBankAccountNum().equals(po.getBankAccountNum())){
					objects.remove((Object)p);     
					objects.add((Object)po);
					findPO=true;
					d.SaveAll(objects, path);
					break;
				}
			}
		}
		if(findPO==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.NOT_FOUND;
		}

	}

	@Override
	public ResultMessage delete(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			BankAccountPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(BankAccountPO)objects.get(i);
				if(p.getBankAccountNum().endsWith(po.getBankAccountNum())){
					findPO=true;
					objects.remove((Object)p);
				}
				break;
			}
			d.SaveAll(objects, path);
		}
		if(findPO==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.NOT_FOUND;
		}

	}

	@Override
	public ArrayList<BankAccountPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects=d.getAll(path);
		ArrayList<BankAccountPO> BankAccountPOs=new ArrayList<BankAccountPO>();
		for(Object o:objects){
			BankAccountPOs.add((BankAccountPO)o);
		}
		return BankAccountPOs;
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
	private void print() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + ": executing " + 
				Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}
