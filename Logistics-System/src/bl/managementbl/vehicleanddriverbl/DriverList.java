package bl.managementbl.vehicleanddriverbl;

import java.util.ArrayList;


public class DriverList {
ArrayList<DriverLineItem> driverList;
public ArrayList<DriverLineItem> getDriverList(){
	return driverList;
}
public String addDriverLineItem(DriverLineItem driverLineItem){
	driverList.add(driverLineItem);
	return null;
}public int getSize(){
	return  driverList.size();
}


}
