package dataimpl.management.vehicleanddriverdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.AccountPO;
import PO.VehiclePO;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;
import datautil.DataUtility;

public class VehicleData extends UnicastRemoteObject implements
		VehicleDataService {
	private final String path = "data/currentdata/vehicle";
	private DataUtility d;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	
	
	
	
	
	
	
	
	
	@Override
	public ResultMessage insertVehicle(VehiclePO po) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		assert (d != null) : ("DataUtility d 未实例化");

		print();
		if (d != null) {
			if (d.save(po, path) == ResultMessage.FAILED) {
				return ResultMessage.FAILED;
			} else {
				return ResultMessage.SUCCESS;
			}
		} else {
			return ResultMessage.FAILED;
		}

	}

	@Override
	public ResultMessage updateVehicle(VehiclePO po)
			throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			VehiclePO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (VehiclePO) objects.get(i);
				if (p.getVehicleNum().equals(po.getVehicleNum())) {
					objects.remove((Object) p);
					objects.add((Object) po);
					findPO = true;
					d.SaveAll(objects, path);
					break;
				}
			}
		}
		if (findPO == true) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.NOT_FOUND;
		}
	}

	@Override
	public ResultMessage deleteVehicle(VehiclePO po) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			VehiclePO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (VehiclePO) objects.get(i);
				if (p.getVehicleNum().equals(po.getVehicleNum())) {
					findPO = true;
					objects.remove((Object) p);
					break;
				}
			}
			d.SaveAll(objects, path);
		}
		if (findPO == true) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.NOT_FOUND;
		}

	}

	@Override
	public ArrayList<VehiclePO> showVehicle() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<VehiclePO> VehiclePOs = new ArrayList<VehiclePO>();
		for (Object o : objects) {
			VehiclePOs.add((VehiclePO) o);
		}
		return VehiclePOs;
	}

	@Override
	public VehiclePO findByVehicleNum(String vehicleNum)
			throws NumNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		VehiclePO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			VehiclePO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (VehiclePO) objects.get(i);
				if (p.getVehicleNum().equals(vehicleNum)) {
					exist = p;
					break;
				}
			}
		}
		if (exist == null) {
			throw new NumNotFoundException();
		} else {
			return exist;
		}
	}

	private void print() {
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getClassName()
				+ ": executing "
				+ Thread.currentThread().getStackTrace()[2].getMethodName());
	}

}
