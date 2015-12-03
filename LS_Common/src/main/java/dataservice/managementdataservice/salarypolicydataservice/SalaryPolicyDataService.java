package dataservice.managementdataservice.salarypolicydataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.SalaryPolicyNotFoundException;
import PO.SalaryPolicyPO;

public interface SalaryPolicyDataService extends Remote{
	public ResultMessage insert(SalaryPolicyPO po)throws RemoteException, IOException;
	public ResultMessage update(SalaryPolicyPO po)throws RemoteException, ClassNotFoundException, IOException;
	public ResultMessage delete(SalaryPolicyPO po)throws RemoteException, IOException, ClassNotFoundException;
	public ArrayList<SalaryPolicyPO> show()throws RemoteException, ClassNotFoundException, IOException;
	public SalaryPolicyPO findByAuthority(Authority  authority)throws RemoteException, FileNotFoundException, SalaryPolicyNotFoundException, ClassNotFoundException, IOException;
	
}
