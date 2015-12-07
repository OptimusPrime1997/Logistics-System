package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class DriverblController implements DriverBLService {
	Driverbl driverbl=new Driverbl();

	public ResultMessage insertDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return driverbl.insertDriver(VO);
	}

	public ResultMessage updateDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return driverbl.updateDriver(VO);
	}

	public ResultMessage deleteDriver(DriverVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return driverbl.deleteDriver(VO);
	}

	public ArrayList<DriverVO> showDriver() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return driverbl.showDriver();
	}

	public DriverVO findByDriverNum(String driverNum) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return driverbl.findByDriverNum(driverNum);
	}

}