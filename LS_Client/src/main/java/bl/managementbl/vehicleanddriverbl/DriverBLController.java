package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class DriverBLController implements DriverBLService {
	VehicleBL driverBL=new VehicleBL();

	public ResultMessage insertDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DriverVO> showDriver() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverVO findByDriverNum(String driverNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}