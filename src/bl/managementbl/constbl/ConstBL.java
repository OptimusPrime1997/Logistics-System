package bl.managementbl.constbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.ConstVO;
import blservice.managementblservice.constblservice.ConstBLService;

public class ConstBL implements ConstBLService {

	@Override
	public util.enumData.ResultMessage insert(ConstVO VO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public util.enumData.ResultMessage update(ConstVO VO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public util.enumData.ResultMessage delete(ConstVO VO)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConstVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstVO findByConstName(String constName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}}
