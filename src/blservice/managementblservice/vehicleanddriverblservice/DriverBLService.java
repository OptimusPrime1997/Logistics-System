package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface DriverBLService {
	public String insertDriver(DriverVO VO)throws RemoteException;
	public String updateDriver(DriverVO VO)throws RemoteException;
	public String deleteDriver(DriverVO VO)throws RemoteException;
	public ArrayList<DriverVO> showDriver()throws RemoteException;
	public DriverVO findByDriverNum(String driverNum)throws RemoteException;
	
}
