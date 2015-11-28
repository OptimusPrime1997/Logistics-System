package dataimpl.management.institutiondata;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import PO.AccountPO;
import PO.InstitutionPO;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import datautil.DataUtility;

public class InstitutionData extends UnicastRemoteObject implements
		InstitutionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataUtility d;
	private final String path = "data/currentdata/institution";

	public InstitutionData() throws RemoteException {
		super();
		d = new DataUtility();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage insert(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		if (d.save(po, path) == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			InstitutionPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (InstitutionPO) objects.get(i);
				if (p.getInstitutionNum().equals(po.getInstitutionNum())) {
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
	public ResultMessage delete(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			InstitutionPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (InstitutionPO) objects.get(i);
				if (p.getInstitutionNum().equals(po.getInstitutionNum())) {
					findPO = true;
					objects.remove((Object) p);
				}
				break;
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
	public ArrayList<InstitutionPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<InstitutionPO> InstitutionPOs = new ArrayList<InstitutionPO>();
		for (Object o : objects) {
			InstitutionPOs.add((InstitutionPO) o);
		}
		return InstitutionPOs;
	}

	@Override
	public InstitutionPO findByName(String name) throws RemoteException,
			FileNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		print();
		InstitutionPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			InstitutionPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (InstitutionPO) objects.get(i);
				if (p.getInstitutionName().equals(name)) {
					exist = p;
					break;
				}
			}
		}
		if (exist == null) {
			throw new NameNotFoundException();
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
