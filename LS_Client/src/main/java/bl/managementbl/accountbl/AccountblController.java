package bl.managementbl.accountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class AccountblController implements AccountBLService {

	Accountbl accountbl = new Accountbl();

	public ResultMessage insert(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.add(VO);
	}

	public ResultMessage update(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.update(VO);
	}

	public ResultMessage delete(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.delete(VO);
	}

	public ResultMessage login(String accountNum, String key)
			throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.login(accountNum, key);
	}

	public ArrayList<AccountVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return accountbl.show();
	}


	public AccountVO findByName(String name) throws FileNotFoundException,
			NameNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountbl.findByName(name);
	}

	public AccountVO findByNum(String num) throws FileNotFoundException,
			NameNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountbl.findByAccountNum(num);
	}

	public ArrayList<AccountVO> findByInstitutionNum(String institutionNum)
			throws NumberFormatException, ClassNotFoundException, IOException,
			NumNotFoundException {
		// TODO Auto-generated method stub
		return accountbl.findByInstitutionNum(institutionNum);
	}

}
