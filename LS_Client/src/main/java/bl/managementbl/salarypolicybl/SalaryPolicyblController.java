package bl.managementbl.salarypolicybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.SalaryPolicyVO;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

public class SalaryPolicyblController implements SalaryPolicyBLService {
	SalaryPolicybl salaryPolicyBL=new SalaryPolicybl();

	public ResultMessage insert(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SalaryPolicyVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public SalaryPolicyVO findBySalaryVOlicyName(String salaryPolicyName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}