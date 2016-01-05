package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.City;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.VehicleVO;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

public class VehicleblController implements VehicleBLService {
	Vehiclebl vehiclebl = new Vehiclebl();

	public ResultMessage insertVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return vehiclebl.insertVehicle(VO);
	}

	public ResultMessage updateVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return vehiclebl.updateVehicle(VO);
	}

	public ResultMessage deleteVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return vehiclebl.deleteVehicle(VO);
	}

	public ArrayList<VehicleVO> showVehicle() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return vehiclebl.showVehicle();
	}

	public ArrayList<VehicleVO> showVehicle(String institutionNum)
			throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return vehiclebl.showVehicle(institutionNum);
	}

	public ArrayList<VehicleVO> showVehicle(City city)
			throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return vehiclebl.showVehicle(city);
	}

	public VehicleVO findByVehicleNum(String VehicleNum)
			throws FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return vehiclebl.findByVehicleNum(VehicleNum);
	}

}