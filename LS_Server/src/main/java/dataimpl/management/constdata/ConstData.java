package dataimpl.management.constdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.City;
import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import PO.ConstPO;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import datautil.DataUtility;

/**
 * @author 1 存取constpo的server端实现
 */
public class ConstData extends UnicastRemoteObject implements ConstDataService {
	private DataUtility d;
	private final String path = "data/currentdata/const";

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
	public ResultMessage update(ConstPO po) throws ClassNotFoundException,
			IOException {
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
				if (p.equals(po)) {
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
	public ResultMessage delete(ConstPO po) throws ClassNotFoundException,
			IOException {
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
				if (p.equals(po)) {
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
	public ArrayList<ConstPO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		ArrayList<Object> objects=null;
		objects= d.getAll(path);
		ArrayList<ConstPO> constPOs = new ArrayList<ConstPO>();
		if (objects == null) {
			return null;
		}else{
			for (Object o : objects) {
				constPOs.add((ConstPO) o);
			}
			return constPOs;
		}

	}

	@Override
	public ConstPO findByCities(City city1,City city2) throws ConstNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		print();
		ConstPO exist = null;
		ArrayList<Object> objects = d.getAll(path);
		if (objects == null) {
			throw new FileNotFoundException();
		} else {
			City c1,c2;
			c1 =City.getCity1(city1, city2);
			c2 = City.getCity2(city1, city2);
			ConstPO p = null;
			for (int i = 0; i < objects.size(); i++) {
				p = (ConstPO) objects.get(i);
				if (p.getCity1()==c1
						&&p.getCity2()==c2) {
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
