package bl.managementbl.institutionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.InstitutionVO;
import blservice.managementblservice.institutionblservice.InstitutionBLService;

public class InstitutionBLController implements InstitutionBLService {
InstitutionBL institutionBL=new InstitutionBL();
	@Override
	public String insert(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InstitutionVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstitutionVO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
