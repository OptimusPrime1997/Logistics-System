package blservice.managementblservice.bankaccountblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.BankAccountVO;

public interface BankAccountBLService {
	public void insert(BankAccountVO VO)throws RemoteException;
	public void update(BankAccountVO VO)throws RemoteException;
	public void delete(BankAccountVO VO)throws RemoteException;
	public ArrayList<BankAccountVO> show()throws RemoteException;
	public BankAccountVO findByName(String name)throws RemoteException;
	public BankAccountVO findByBankAccountNum(String bankAccountNum)throws RemoteException;
	
}
