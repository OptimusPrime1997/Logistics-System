package dataservice.managementdataservice.vehicleanddriverdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.DriverPO;

public interface DriverDataService extends Remote {
	public ResultMessage insertDriver(DriverPO po) throws RemoteException,
			IOException;

	public ResultMessage updateDriver(DriverPO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ResultMessage deleteDriver(DriverPO po) throws RemoteException,
			IOException, ClassNotFoundException;

	public ArrayList<DriverPO> showDriver() throws RemoteException,
			ClassNotFoundException, IOException;

	public DriverPO findByDriverNum(String driverNum) throws RemoteException,
			NumNotFoundException, FileNotFoundException,
			ClassNotFoundException, IOException;

}
