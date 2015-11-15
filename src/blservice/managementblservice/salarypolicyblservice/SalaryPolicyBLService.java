package blservice.managementblservice.salarypolicyblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface SalaryPolicyBLService {
	public String insert(SalaryPolicyVO VO)throws RemoteException;
	public String update(SalaryPolicyVO VO)throws RemoteException;
	public String delete(SalaryPolicyVO VO)throws RemoteException;
	public ArrayList<SalaryPolicyVO> show()throws RemoteException;
	public SalaryPolicyVO findBySalaryVOlicyName(String salaryPolicyName)throws RemoteException;
	
}
