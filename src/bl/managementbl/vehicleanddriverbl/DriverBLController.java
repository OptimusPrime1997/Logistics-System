package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class DriverBLController implements DriverBLService {
DriverBL driverBL=new DriverBL();
	@Override
	public String insertDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDriver(DriverVO VO) throws RemoteException {
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
	}

}
