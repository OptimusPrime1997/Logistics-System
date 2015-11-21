package bl.managementbl.constbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.ConstVO;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.constblservice.ConstBLService;

public class Constbl {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
}
