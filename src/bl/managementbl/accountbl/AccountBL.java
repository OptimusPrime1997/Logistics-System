package bl.managementbl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class AccountBL implements AccountBLService{

	@Override
	public ResultMessage insert(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage login(String name, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateMsg(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountVO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountVO findByInstitutionName(String institutionName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
