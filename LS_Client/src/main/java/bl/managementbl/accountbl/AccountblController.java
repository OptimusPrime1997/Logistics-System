package bl.managementbl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class AccountblController implements AccountBLService {
	Accountbl accountBL=new Accountbl();

	public ResultMessage insert(AccountVO VO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(AccountVO VO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(AccountVO VO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage login(String accountNum, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AccountVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateMsg(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO findByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO findByInstitutionName(String institutionName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addLog(LogVO logvo) {
		// TODO Auto-generated method stub
		return null;
	}

}
