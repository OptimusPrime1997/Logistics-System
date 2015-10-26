package blservice.managementblservice.salarypolicyblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface SalaryPolicyBLService {
	public void insert(SalaryPolicyVO VO)throws RemoteException;
	public void update(SalaryPolicyVO VO)throws RemoteException;
	public void delete(SalaryPolicyVO VO)throws RemoteException;
	public ArrayList<SalaryPolicyVO> show()throws RemoteException;
	public SalaryPolicyVO findBySalaryVOlicyName(String salaryPolicyName)throws RemoteException;
	
}
