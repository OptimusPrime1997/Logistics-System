package bl.managementbl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AccountPO;
import dataservice.datafactoryservice.DataFactoryImpl;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import util.CurrentTime;
import util.InputCheck;
import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;

public class Accountbl {
	public ResultMessage createLog(String operationName,String info){	
		try{
			AccountDataService accountDataService=DataFactoryImpl.getInstance().getAccountData();
		}catch(Exception e){
			e.printStackTrace();
		}
		Logbl logbl=new Logbl();
		LogVO logVO=new LogVO(operationName, Loginbl.getCurrentOptorId(), CurrentTime.getTime());
		logbl.add(logVO);
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage add(AccountVO vo) throws RemoteException {
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage update(AccountVO vo) throws RemoteException {

		// TODO Auto-generated method stub
//		try {
//		accountDataService.update(new PO.AccountPO(vo.accountNum,vo.accountName,
//				vo.password,vo.sex,vo.authority,vo.phoneNum,vo.institution));
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return ResultMessage.SUCCESS;
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
