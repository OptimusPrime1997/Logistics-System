package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.VehicleVO;
import bl.managementbl.accountbl.MockLog;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

public class Vehiclebl  {
	public ResultMessage createLog(String content){	
	MockLog log = new MockLog(content);
	return log.add();		
}}
