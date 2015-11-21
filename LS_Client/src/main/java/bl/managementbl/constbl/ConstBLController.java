package bl.managementbl.constbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.ConstVO;
import blservice.managementblservice.constblservice.ConstBLService;

public class ConstBLController implements ConstBLService {
	ConstBL constBL=new ConstBL();

	public ResultMessage insert(ConstVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(ConstVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(ConstVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ConstVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConstVO findByConstName(String constName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
