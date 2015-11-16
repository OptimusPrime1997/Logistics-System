package bl.managementbl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class AccountBL implements AccountBLService{
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
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

	@Override
	public ResultMessage addLog(LogVO logvo) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}
	}
