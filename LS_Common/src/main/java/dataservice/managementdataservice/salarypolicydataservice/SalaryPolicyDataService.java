package dataservice.managementdataservice.salarypolicydataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.SalaryPolicyNotFoundException;
import PO.SalaryPolicyPO;

public interface SalaryPolicyDataService {
	public ResultMessage insert(SalaryPolicyPO po)throws RemoteException;
	public ResultMessage update(SalaryPolicyPO po)throws RemoteException;
	public ResultMessage delete(SalaryPolicyPO po)throws RemoteException;
	public ArrayList<SalaryPolicyPO> show()throws RemoteException;
	public SalaryPolicyPO findByAuthority(Authority  authority)throws RemoteException, FileNotFoundException, SalaryPolicyNotFoundException;
	
}
