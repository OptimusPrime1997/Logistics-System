package blservice.managementblservice.accountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;


public interface  AccountBLService {
	
		public ResultMessage insert(AccountVO VO);
		public ResultMessage update(AccountVO VO);
		public ResultMessage delete(AccountVO VO);
		public ResultMessage login(String accountNum,String key);
		public ArrayList<AccountVO> show();
		public ResultMessage  updateMsg(AccountVO vo);
		public AccountVO findByName(String name);
		public AccountVO findByNum(String num);

		public AccountVO findByInstitutionName(String institutionName);
		public ResultMessage addLog(LogVO logvo);
	

}
