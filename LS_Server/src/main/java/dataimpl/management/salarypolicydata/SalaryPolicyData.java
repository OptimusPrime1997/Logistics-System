package dataimpl.management.salarypolicydata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.SalaryPolicyNotFoundException;
import PO.AccountPO;
import PO.SalaryPolicyPO;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import datautil.DataUtility;

public class SalaryPolicyData extends UnicastRemoteObject implements
		SalaryPolicyDataService {
	private final String path = "data/currentdata/account";
	private DataUtility d;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SalaryPolicyData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	@Override
	public ResultMessage insert(SalaryPolicyPO po) throws IOException {
		// TODO Auto-generated method stub
		print();
		if (d.save(po, path) == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(SalaryPolicyPO po) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			SalaryPolicyPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(SalaryPolicyPO)objects.get(i);
				if(p.getAuthority()==(po.getAuthority())){
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
	public ResultMessage delete(SalaryPolicyPO po) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		print();
		boolean findPO=false;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			return ResultMessage.NOT_FOUND_FILE;
		}else{
			SalaryPolicyPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(SalaryPolicyPO)objects.get(i);
				if(p.getAuthority()==(po.getAuthority())){
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
		}	}

	@Override
	public ArrayList<SalaryPolicyPO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects=d.getAll(path);
		ArrayList<SalaryPolicyPO> SalaryPolicyPOs=new ArrayList<SalaryPolicyPO>();
		for(Object o:objects){
			SalaryPolicyPOs.add((SalaryPolicyPO)o);
		}
		return SalaryPolicyPOs;
	}

	@Override
	public SalaryPolicyPO findByAuthority(Authority authority)
			throws SalaryPolicyNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		SalaryPolicyPO exist=null;
		ArrayList<Object> objects=d.getAll(path);
		if(objects==null){
			throw new FileNotFoundException();
		}else{
			SalaryPolicyPO p=null;
			for(int i=0;i<objects.size();i++){
				p=(SalaryPolicyPO)objects.get(i);
				if(p.getAuthority()==(authority)){
					exist=p;
					break;
				}
			}
		}
		if(exist==null){
			throw new SalaryPolicyNotFoundException();
		}else{
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
