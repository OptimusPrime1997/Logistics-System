package blservice.managementblservice.bankaccountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import VO.ManagementVO.BankAccountVO;

public interface BankAccountBLService {
	public ResultMessage insert(BankAccountVO VO)throws RemoteException;
	public ResultMessage update(BankAccountVO VO)throws RemoteException;
	public ResultMessage delete(BankAccountVO VO)throws RemoteException;
	public ArrayList<BankAccountVO> show()throws RemoteException;
	public BankAccountVO findByName(String  name)throws RemoteException;
	public BankAccountVO findByBankAccountNum(String bankAccountNum)throws RemoteException;
	
}
