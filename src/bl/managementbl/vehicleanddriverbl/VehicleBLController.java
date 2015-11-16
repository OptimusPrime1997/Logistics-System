package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.VehicleVO;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

public class VehicleBLController implements VehicleBLService {
VehicleBL vehicleBL=new VehicleBL();
	@Override
	public String insertVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleVO> showVehicle() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleVO findByVehicleNum(String VehicleNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
