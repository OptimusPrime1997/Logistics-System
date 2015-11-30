package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.DriverPO;

public interface DriverDataService {
	public ResultMessage insertDriver(DriverPO po)throws RemoteException;
	public ResultMessage updateDriver(DriverPO po)throws RemoteException;
	public ResultMessage deleteDriver(DriverPO po)throws RemoteException;
	public ArrayList<DriverPO> showDriver()throws RemoteException;
	public DriverPO findByDriverNum(String driverNum)throws RemoteException,  NumNotFoundException, FileNotFoundException;
	

}
