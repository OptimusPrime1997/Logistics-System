package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.VehiclePO;

public interface VehicleDataService extends Remote {
	public ResultMessage insertVehicle(VehiclePO po) throws RemoteException,
			IOException;

	public ResultMessage updateVehicle(VehiclePO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ResultMessage deleteVehicle(VehiclePO po) throws RemoteException,
			IOException, ClassNotFoundException;

	public ArrayList<VehiclePO> showVehicle() throws RemoteException,
			ClassNotFoundException, IOException;

	public VehiclePO findByVehicleNum(String vehicleNum)
			throws RemoteException, FileNotFoundException,
			NumNotFoundException, ClassNotFoundException, IOException;

}
