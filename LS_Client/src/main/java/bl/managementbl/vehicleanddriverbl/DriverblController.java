package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.City;
import util.enumData.ResultMessage;
import Exception.AutoNumException;
import Exception.ExistException;
import Exception.NumNotFoundException;
import VO.ManagementVO.DriverVO;
import blservice.managementblservice.vehicleanddriverblservice.DriverBLService;

public class DriverblController implements DriverBLService {
	Driverbl driverbl = new Driverbl();

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

	public ArrayList<DriverVO> showDriver() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return driverbl.showDriver();
	}

	public ArrayList<DriverVO> showDriver(String institutionNum)
			throws ClassNotFoundException, IOException {
		return driverbl.showDriver(institutionNum);
	}

	public ArrayList<DriverVO> showDriver(City city)
			throws ClassNotFoundException, IOException {
		return driverbl.showDriver(city);
	}

	public DriverVO findByDriverNum(String driverNum)
			throws FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return driverbl.findByDriverNum(driverNum);
	}

}