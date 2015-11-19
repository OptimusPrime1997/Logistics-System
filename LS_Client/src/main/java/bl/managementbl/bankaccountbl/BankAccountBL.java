package bl.managementbl.bankaccountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;

public class BankAccountBL {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
	}
