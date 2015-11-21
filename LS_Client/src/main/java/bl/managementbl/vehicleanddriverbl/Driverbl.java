package bl.managementbl.vehicleanddriverbl;

import util.enumData.ResultMessage;
import bl.managementbl.accountbl.MockLog;

public class Driverbl {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
}
