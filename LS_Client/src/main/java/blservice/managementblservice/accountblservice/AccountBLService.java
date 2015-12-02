package blservice.managementblservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;

public interface AccountBLService {

	public ResultMessage insert(AccountVO VO) throws RemoteException;

	public ResultMessage update(AccountVO VO) throws RemoteException;

	public ResultMessage delete(AccountVO VO) throws RemoteException;

	public ResultMessage login(String accountNum, String key)
			throws RemoteException;

	public ArrayList<AccountVO> show() throws RemoteException;

	public ResultMessage updateMsg(AccountVO vo) throws RemoteException;

	public AccountVO findByName(String name) throws RemoteException;

	public AccountVO findByNum(String num) throws RemoteException;

	public ArrayList<AccountVO> findByInstitutionNum(String institutionNum)
			throws RemoteException;

	public ResultMessage addLog(LogVO logvo) throws RemoteException;

}
