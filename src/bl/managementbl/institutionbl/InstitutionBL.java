


package bl.managementbl.institutionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.institutionblservice.InstitutionBLService;
import VO.ManagementVO.InstitutionVO;


public class InstitutionBL  {public ResultMessage createLog(String content){	
	MockLog log = new MockLog(content);
	return log.add();		
}}
