package bl.managementbl.vehicleanddriverbl;

import java.util.ArrayList;

import VO.ManagementVO.DriverVO;


public class DriverList {
ArrayList<DriverVO> driverList;
public ArrayList<DriverVO> getDriverList(){
	return driverList;
}
public String addDriverVO(DriverVO DriverVO){
	driverList.add(DriverVO);
	return null;
}public int getSize(){
	return  driverList.size();
}
public ArrayList<DriverVO> getList(){
	return driverList;
}



}
