package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface DriverBLService {
	public void insertDriver(DriverVO VO)throws RemoteException;
	public void updateDriver(DriverVO VO)throws RemoteException;
	public void deleteDriver(DriverVO VO)throws RemoteException;
	public ArrayList<DriverVO> showDriver()throws RemoteException;
	public DriverVO findByDriverNum(String driverNum)throws RemoteException;
	
}
