package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.VehiclePO;

public interface VehicleDataService {
	public void insertVehicle(VehiclePO po)throws RemoteException;
	public void updateVehicle(VehiclePO po)throws RemoteException;
	public void deleteVehicle(VehiclePO po)throws RemoteException;
	public ArrayList<VehiclePO> showVehicle()throws RemoteException;
	public VehiclePO findByVehicleNum(String vehicleNum)throws RemoteException;
	
}
