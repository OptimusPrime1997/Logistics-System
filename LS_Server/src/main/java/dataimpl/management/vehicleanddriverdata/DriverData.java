package dataimpl.management.vehicleanddriverdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.DriverPO;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;

public class DriverData implements DriverDataService {

	@Override
	public ResultMessage insertDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverPO> showDriver() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPO findByDriverNum(String driverNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
