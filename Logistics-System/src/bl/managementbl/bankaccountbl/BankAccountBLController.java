package bl.managementbl.bankaccountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.BankAccountVO;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;

public class BankAccountBLController implements BankAccountBLService{
	BankAccountBL  bankAccountBL=new BankAccountBL();

	@Override
	public ResultMessage insert(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(BankAccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountVO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountVO findByBankAccountNum(String bankAccountNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}}
