package blservice.managementblservice.vehicleanddriverblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.AutoNumException;
import Exception.ExistException;
import Exception.NumNotFoundException;
import VO.ManagementVO.*;

public interface DriverBLService {
	public ResultMessage insertDriver(DriverVO vo) throws RemoteException;

	public ResultMessage updateDriver(DriverVO vo) throws RemoteException;

	public ResultMessage deleteDriver(DriverVO vo) throws RemoteException;

	public ArrayList<DriverVO> showDriver() throws RemoteException,
			ClassNotFoundException, IOException;
	
	public ArrayList<DriverVO> showDriver(String institutionNum) throws RemoteException,
	ClassNotFoundException, IOException;
	
	public DriverVO findByDriverNum(String driverNum) throws RemoteException,
			FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException;

}
