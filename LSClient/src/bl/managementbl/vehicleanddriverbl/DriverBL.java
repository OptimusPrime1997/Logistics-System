package bl.managementbl.vehicleanddriverbl;

import util.enumData.ResultMessage;
import bl.managementbl.accountbl.MockLog;

public class DriverBL {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
}
