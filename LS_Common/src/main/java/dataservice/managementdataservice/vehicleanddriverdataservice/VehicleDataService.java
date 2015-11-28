package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.VehiclePO;

public interface VehicleDataService {
	public ResultMessage insertVehicle(VehiclePO po)throws RemoteException;
	public ResultMessage updateVehicle(VehiclePO po)throws RemoteException;
	public ResultMessage deleteVehicle(VehiclePO po)throws RemoteException;
	public ArrayList<VehiclePO> showVehicle()throws RemoteException;
	public VehiclePO findByVehicleNum(String vehicleNum)throws RemoteException, FileNotFoundException, NumNotFoundException;
	
}
