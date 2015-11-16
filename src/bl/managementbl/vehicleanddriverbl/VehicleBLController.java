package bl.managementbl.vehicleanddriverbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.VehicleVO;
import blservice.managementblservice.vehicleanddriverblservice.VehicleBLService;

public class VehicleBLController implements VehicleBLService {
	VehicleBL vehicleBL=new VehicleBL();

	@Override
	public ResultMessage insertVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateVehicle(VehicleVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteVehicle(VehicleVO VO) throws RemoteException {
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
	}}
