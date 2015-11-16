package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.*;

public interface VehicleBLService {
	public ResultMessage insertVehicle(VehicleVO VO)throws RemoteException;
	public ResultMessage updateVehicle(VehicleVO VO)throws RemoteException;
	public ResultMessage deleteVehicle(VehicleVO VO)throws RemoteException;
	public ArrayList<VehicleVO> showVehicle()throws RemoteException;
	public VehicleVO findByVehicleNum(String VehicleNum)throws RemoteException;
	
}
