package blservice.managementblservice.bankaccountblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.BankAccountVO;

public interface BankAccountBLService {
	public ResultMessage insert(BankAccountVO VO)throws RemoteException;
	public ResultMessage update(BankAccountVO VO)throws RemoteException;
	public ResultMessage delete(BankAccountVO VO)throws RemoteException;
	public ArrayList<BankAccountVO> show()throws RemoteException, ClassNotFoundException, IOException;
	public BankAccountVO findByName(String  name)throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException;
	public BankAccountVO findByBankAccountNum(String bankAccountNum)throws RemoteException, FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;
	
}
