package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DriverPO;

public interface DriverDataService {
	public void insertDriver(DriverPO po)throws RemoteException;
	public void updateDriver(DriverPO po)throws RemoteException;
	public void deleteDriver(DriverPO po)throws RemoteException;
	public ArrayList<DriverPO> showDriver()throws RemoteException;
	public DriverPO findByDriverNum(String driverNum)throws RemoteException;
	

}
