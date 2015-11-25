package bl.managementbl.institutionbl;

import util.enumData.ResultMessage;
import bl.managementbl.accountbl.MockLog;


public class Institutionbl  {public ResultMessage createLog(String content){	
	MockLog log = new MockLog(content);
	return log.add();		
}}
