package bl.managementbl.salarypolicybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.SalaryPolicyVO;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.salarypolicyblservice.SalaryPolicyBLService;

public class SalaryPolicybl{public ResultMessage createLog(String content){	
	MockLog log = new MockLog(content);
	return log.add();		
}}
