package bl.managementbl.vehicleanddriverbl;

import java.util.ArrayList;

import VO.ManagementVO.VehicleVO;


public class VehicleList {
ArrayList<VehicleVO> vehicleList;
public ArrayList<VehicleVO> getVehicleList(){
	return vehicleList;
}
public String addVehicleVO(VehicleVO VehicleVO){
	vehicleList.add(VehicleVO);
	return null;
}
public int getSize(){
	return  vehicleList.size();
}

public ArrayList<VehicleVO> getList(){
	return vehicleList;
}

}
