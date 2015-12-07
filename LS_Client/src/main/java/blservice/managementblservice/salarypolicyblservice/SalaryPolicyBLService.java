package blservice.managementblservice.salarypolicyblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.ManagementVO.*;

public interface SalaryPolicyBLService {
	public ResultMessage insert(SalaryPolicyVO vo)throws RemoteException;
	public ResultMessage update(SalaryPolicyVO vo)throws RemoteException;
	public ResultMessage delete(SalaryPolicyVO vo)throws RemoteException;
	public ArrayList<SalaryPolicyVO> show()throws RemoteException, ClassNotFoundException, IOException;
	public SalaryPolicyVO findByAuthority(Authority authority)throws RemoteException, FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException, NumNotFoundException;
	
}
