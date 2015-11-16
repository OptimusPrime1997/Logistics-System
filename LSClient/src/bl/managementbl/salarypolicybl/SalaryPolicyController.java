package bl.managementbl.salarypolicybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.SalaryPolicyVO;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

public class SalaryPolicyController implements SalaryPolicyBLService {
	SalaryPolicyBL salaryPolicyBL=new SalaryPolicyBL();

	@Override
	public ResultMessage insert(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(SalaryPolicyVO VO) throws RemoteException {
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
	}}
