package bl.managementbl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

import javax.print.attribute.standard.RequestingUserName;

import util.InputCheck;
import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import blservice.managementblservice.accountblservice.AccountBLService;

public class Accountbl {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
	

	
	public ResultMessage add(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	public ResultMessage update(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage delete(AccountVO VO) throws RemoteException {
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
	public ResultMessage login(String accountNum,String key){
		if(InputCheck.checkInputNum(accountNum, 10)==ResultMessage.WRONG){
			return ResultMessage.WRONG;
		}else{
			AccountVO accountVO=findByNum(accountNum);
			if(accountVO==null){
				return ResultMessage.NOT_FOUND;
			}else if(accountVO.password.equals(key)){
				return ResultMessage.SUCCESS;
			}else{
				return ResultMessage.WRONG_PASSWORD;
			}
		}
	}
	}
