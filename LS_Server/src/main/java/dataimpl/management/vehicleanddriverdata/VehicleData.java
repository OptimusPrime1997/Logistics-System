package dataimpl.management.vehicleanddriverdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.VehiclePO;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public class VehicleData implements VehicleDataService {

	@Override
	public ResultMessage insertVehicle(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateVehicle(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteVehicle(VehiclePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehiclePO> showVehicle() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiclePO findByVehicleNum(String vehicleNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
