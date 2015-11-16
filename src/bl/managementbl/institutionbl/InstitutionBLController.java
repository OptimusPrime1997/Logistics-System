package bl.managementbl.institutionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.InstitutionVO;
import blservice.managementblservice.institutionblservice.InstitutionBLService;

public class InstitutionBLController implements InstitutionBLService {
	InstitutionBL institutionBL=new InstitutionBL();

	@Override
	public ResultMessage insert(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(InstitutionVO VO) throws RemoteException {
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
	}}
