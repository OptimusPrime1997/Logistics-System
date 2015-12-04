package bl.managementbl.accountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class AccountblController implements AccountBLService {

	Accountbl accountbl=new Accountbl();
	@Override
	public ResultMessage insert(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.add(VO);
	}

	@Override
	public ResultMessage update(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.update(VO);
	}

	@Override
	public ResultMessage delete(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.delete(VO);
	}

	@Override
	public ResultMessage login(String accountNum, String key)
			throws RemoteException {
		// TODO Auto-generated method stub
		return accountbl.login(accountNum, key);
	}

	@Override
	public ArrayList<AccountVO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountbl.show();
	}

	@Override
	public ResultMessage updateMsg(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountVO findByName(String name) throws FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountbl.findByName(name);
	}

	@Override
	public AccountVO findByNum(String num) throws FileNotFoundException, NameNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return accountbl.findByAccountNum(num);
	}

	@Override
	public ArrayList<AccountVO> findByInstitutionNum(String institutionNum)
			throws NumberFormatException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return accountbl.findByInstitutionNum(institutionNum);
	}

}
