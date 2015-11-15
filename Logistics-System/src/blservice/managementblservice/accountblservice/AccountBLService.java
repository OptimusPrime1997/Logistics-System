package blservice.managementblservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.AccountVO;


public interface  AccountBLService {
	
		public String insert(AccountVO VO)throws RemoteException;
		public String update(AccountVO VO)throws RemoteException;
		public String delete(AccountVO VO)throws RemoteException;
		public String login(String name,String key);
		public ArrayList<AccountVO> show()throws RemoteException;
		public String  updateMsg(AccountVO vo)throws RemoteException;
		public AccountVO findByName(String name)throws RemoteException;
		public AccountVO findByInstitutionName(String institutionName)throws RemoteException;
		
	

}
