package blservice.managementblservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.AccountVO;


public interface  AccountBLService {
	
		public ResultMessage insert(AccountVO VO)throws RemoteException;
		public ResultMessage update(AccountVO VO)throws RemoteException;
		public ResultMessage delete(AccountVO VO)throws RemoteException;
		public ResultMessage login(String name,String key);
		public ArrayList<AccountVO> show()throws RemoteException;
		public ResultMessage  updateMsg(AccountVO vo)throws RemoteException;
		public AccountVO findByName(String name)throws RemoteException;
		public AccountVO findByInstitutionName(String institutionName)throws RemoteException;
		
	

}
