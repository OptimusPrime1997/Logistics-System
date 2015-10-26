package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface VehicleBLService {
	public void insertVehicle(VehicleVO VO)throws RemoteException;
	public void updateVehicle(VehicleVO VO)throws RemoteException;
	public void deleteVehicle(VehicleVO VO)throws RemoteException;
	public ArrayList<VehicleVO> showVehicle()throws RemoteException;
	public VehicleVO findByVehicleNum(String VehicleNum)throws RemoteException;
	
}
