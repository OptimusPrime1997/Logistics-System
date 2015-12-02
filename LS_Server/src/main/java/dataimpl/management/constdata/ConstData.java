package dataimpl.management.constdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;







import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import PO.ConstPO;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import datautil.DataUtility;

public class ConstData extends UnicastRemoteObject implements ConstDataService {
	private DataUtility d;
	private final String path = "data/currentdata/const";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConstData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		d = new DataUtility();
	}

	@Override
	public ResultMessage insert(ConstPO po) throws IOException {
		// TODO Auto-generated method stub
		print();
		if (d.save(po, path) == ResultMessage.FAILED) {
			return ResultMessage.FAILED;
		} else {
			return ResultMessage.SUCCESS;
		}
	}

	@Override
	public ResultMessage update(ConstPO po) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			ConstPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (ConstPO) objects.get(i);
				if (p.getTwoCities().equals(po.getTwoCities())) {
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
	public ResultMessage delete(ConstPO po) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		boolean findPO = false;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			return ResultMessage.NOT_FOUND_FILE;
		} else {
			ConstPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (ConstPO) objects.get(i);
				if (p.getTwoCities().equals(po.getTwoCities())) {
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
	public ArrayList<ConstPO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects = d.getAll(path);
		ArrayList<ConstPO> ConstPOs = new ArrayList<ConstPO>();
		for (Object o : objects) {
			ConstPOs.add((ConstPO) o);
		}
		return ConstPOs;

	}

	@Override
	public ConstPO findByCities(String cities) throws ConstNotFoundException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		print();
		ConstPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			ConstPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (ConstPO) objects.get(i);
				if (p.getTwoCities().equals(cities)) {
					exist = p;
					break;
				}
			}
		}
		if (exist == null) {
			throw new ConstNotFoundException();
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
