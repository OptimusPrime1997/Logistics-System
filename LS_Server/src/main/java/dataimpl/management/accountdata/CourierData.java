package dataimpl.management.accountdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.CourierPO;
import dataservice.managementdataservice.accountdataservice.CourierDataService;
import datautil.DataUtility;

public class CourierData extends UnicastRemoteObject implements
		CourierDataService, Serializable {
	private final String path = "data/currentdata/courier";
	private DataUtility d;
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	public CourierData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	@Override
	public ResultMessage insert(CourierPO po) throws IOException,
			FileNotFoundException {
		// TODO Auto-generated method stub
		print();
		if (d.save(po, path) == ResultMessage.SUCCESS) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAILED;
		}
	}

	@Override
	public ResultMessage update(CourierPO po) throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			CourierPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (CourierPO) objects.get(i);
				if (p.getCourierNum().equals(po.getCourierNum())) {
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
	public ResultMessage delete(CourierPO po) throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			CourierPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (CourierPO) objects.get(i);
				if (p.getCourierNum().equals(po.getCourierNum())) {
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
	public ArrayList<CourierPO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<CourierPO> accountPOs = new ArrayList<CourierPO>();
		for (Object o : objects) {
			accountPOs.add((CourierPO) o);
		}
		return accountPOs;
	}

	@Override
	public CourierPO findByCourierNum(String accountNum)
			throws NumNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		CourierPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			CourierPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (CourierPO) objects.get(i);
				if (p.getCourierNum().equals(accountNum)) {
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
