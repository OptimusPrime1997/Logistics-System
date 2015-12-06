package bl.managementbl.institutionbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.InstitutionNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.InstitutionVO;
import blservice.managementblservice.institutionblservice.InstitutionBLService;

public class InstitutionblController implements InstitutionBLService {
	Institutionbl institutionbl = new Institutionbl();

	public ResultMessage insert(InstitutionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return institutionbl.insert(vo);
	}

	public ResultMessage update(InstitutionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return institutionbl.update(vo);
	}

	public ResultMessage delete(InstitutionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return institutionbl.delete(vo);
	}

	public ArrayList<InstitutionVO> show() throws ClassNotFoundException,
			IOException,RemoteException {
		// TODO Auto-generated method stub
		return institutionbl.show();
	}

	@Override
	public InstitutionVO findByInstitutionNum(String institutionNum)
			throws FileNotFoundException, ClassNotFoundException,
			InstitutionNotFoundException, IOException,RemoteException, NumNotFoundException {
		// TODO Auto-generated method stub
		return institutionbl.findByInstitutionNum(institutionNum);
	}

}
