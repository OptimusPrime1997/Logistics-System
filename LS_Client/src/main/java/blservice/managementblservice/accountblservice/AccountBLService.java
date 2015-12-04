package blservice.managementblservice.accountblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.LogVO;
import VO.ManagementVO.AccountVO;

public interface AccountBLService {

	public ResultMessage insert(AccountVO VO) throws RemoteException, ClassNotFoundException;

	public ResultMessage update(AccountVO VO) throws RemoteException;

	public ResultMessage delete(AccountVO VO) throws RemoteException;

	public ResultMessage login(String accountNum, String key)
			throws RemoteException;

	public ArrayList<AccountVO> show() throws RemoteException, ClassNotFoundException, IOException;

	public ResultMessage updateMsg(AccountVO vo) throws RemoteException;

	public AccountVO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException;

	public AccountVO findByNum(String num) throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;

	public ArrayList<AccountVO> findByInstitutionNum(String institutionNum)
			throws RemoteException, NumberFormatException, ClassNotFoundException, IOException, NumNotFoundException;


}
