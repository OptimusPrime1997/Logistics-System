package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;
import blservice.managementblservice.vehicleanddriverblservice.ResultMessage;

public class DriverBL implements DriverBLService {

	@Override
	public ResultMessage insertDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverVO> showDriver() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO findByDriverNum(String driverNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}}
