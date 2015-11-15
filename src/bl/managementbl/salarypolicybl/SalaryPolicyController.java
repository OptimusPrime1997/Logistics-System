package bl.managementbl.salarypolicybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.SalaryPolicyVO;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

public class SalaryPolicyController implements SalaryPolicyBLService {
SalaryPolicyBL salaryPolicyBL=new SalaryPolicyBL();
	@Override
	public String insert(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalaryPolicyVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryPolicyVO findBySalaryVOlicyName(String salaryPolicyName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
