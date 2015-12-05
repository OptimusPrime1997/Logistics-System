package bl.managementbl.bankaccountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.BankAccountVO;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;

public class BankAccountblController implements BankAccountBLService{
	BankAccountbl  bankAccountbl=new BankAccountbl();

	public ResultMessage insert(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return bankAccountbl.add(VO);
	}

	public ResultMessage update(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return bankAccountbl.update(VO);
	}

	public ResultMessage delete(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return bankAccountbl.delete(VO);
	}

	public ArrayList<BankAccountVO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return bankAccountbl.show();
	}

	public BankAccountVO findByName(String name) throws FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return bankAccountbl.findByName(name);
	}

	public BankAccountVO findByBankAccountNum(String bankAccountNum) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return bankAccountbl.findByBankAccountNum(bankAccountNum);
	}
}
