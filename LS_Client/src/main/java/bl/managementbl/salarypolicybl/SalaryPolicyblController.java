package bl.managementbl.salarypolicybl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.ManagementVO.SalaryPolicyVO;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

public class SalaryPolicyblController implements SalaryPolicyBLService {
	SalaryPolicybl salaryPolicybl = new SalaryPolicybl();

	@Override
	public ResultMessage insert(SalaryPolicyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return salaryPolicybl.insert(vo);
	}

	@Override
	public ResultMessage update(SalaryPolicyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return salaryPolicybl.update(vo);
	}

	@Override
	public ResultMessage delete(SalaryPolicyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return salaryPolicybl.delete(vo);
	}

	@Override
	public ArrayList<SalaryPolicyVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return salaryPolicybl.show();
	}

	@Override
	public SalaryPolicyVO findByAuthority(Authority authority)
			throws FileNotFoundException, ClassNotFoundException,
			SalaryPolicyNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return salaryPolicybl.findByAuthority(authority);
	}
}