package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.VehiclePO;

public interface VehicleDataService {
	public String insertVehicle(VehiclePO po)throws RemoteException;
	public String updateVehicle(VehiclePO po)throws RemoteException;
	public String deleteVehicle(VehiclePO po)throws RemoteException;
	public ArrayList<VehiclePO> showVehicle()throws RemoteException;
	public VehiclePO findByVehicleNum(String vehicleNum)throws RemoteException;
	
}
