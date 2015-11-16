package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.DriverVO;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class VehicleLineItemBL  {
	public ResultMessage createLog(String content){	
	MockLog log = new MockLog(content);
	return log.add();		
}}
