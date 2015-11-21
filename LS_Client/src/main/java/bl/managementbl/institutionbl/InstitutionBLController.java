package bl.managementbl.institutionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.InstitutionVO;
import blservice.managementblservice.institutionblservice.InstitutionBLService;

public class InstitutionblController implements InstitutionBLService {
	Institutionbl institutionBL=new Institutionbl();

	public ResultMessage insert(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InstitutionVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public InstitutionVO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
