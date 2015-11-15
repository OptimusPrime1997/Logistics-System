package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface VehicleBLService {
	public String insertVehicle(VehicleVO VO)throws RemoteException;
	public String updateVehicle(VehicleVO VO)throws RemoteException;
	public String deleteVehicle(VehicleVO VO)throws RemoteException;
	public ArrayList<VehicleVO> showVehicle()throws RemoteException;
	public VehicleVO findByVehicleNum(String VehicleNum)throws RemoteException;
	
}
