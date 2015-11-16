package bl.managementbl.vehicleanddriverbl;

import java.util.ArrayList;


public class VehicleList {
ArrayList<VehicleLineItem> vehicleList;
public ArrayList<VehicleLineItem> getVehicleList(){
	return vehicleList;
}
public String addVehicleLineItem(VehicleLineItem vehicleLineItem){
	vehicleList.add(vehicleLineItem);
	return null;
}
}
