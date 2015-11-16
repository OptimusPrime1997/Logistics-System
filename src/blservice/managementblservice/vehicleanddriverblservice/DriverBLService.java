package blservice.managementblservice.vehicleanddriverblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.*;

public interface DriverBLService {
	public ResultMessage insertDriver(DriverVO VO)throws RemoteException;
	public ResultMessage updateDriver(DriverVO VO)throws RemoteException;
	public ResultMessage deleteDriver(DriverVO VO)throws RemoteException;
	public ArrayList<DriverVO> showDriver()throws RemoteException;
	public DriverVO findByDriverNum(String driverNum)throws RemoteException;
	
}
