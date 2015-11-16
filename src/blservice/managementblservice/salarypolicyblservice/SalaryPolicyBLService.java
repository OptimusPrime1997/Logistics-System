package blservice.managementblservice.salarypolicyblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.*;

public interface SalaryPolicyBLService {
	public ResultMessage insert(SalaryPolicyVO VO)throws RemoteException;
	public ResultMessage update(SalaryPolicyVO VO)throws RemoteException;
	public ResultMessage delete(SalaryPolicyVO VO)throws RemoteException;
	public ArrayList<SalaryPolicyVO> show()throws RemoteException;
	public SalaryPolicyVO findBySalaryVOlicyName(String salaryPolicyName)throws RemoteException;
	
}
