package dataservice.managementdataservice.salarypolicydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SalaryPolicyPO;

public interface SalaryPolicyDataService {
	public void insert(SalaryPolicyPO po)throws RemoteException;
	public void update(SalaryPolicyPO po)throws RemoteException;
	public void delete(SalaryPolicyPO po)throws RemoteException;
	public ArrayList<SalaryPolicyPO> show()throws RemoteException;
	public SalaryPolicyPO findBySalaryPolicyName(String salaryPolicyName)throws RemoteException;
	
}
