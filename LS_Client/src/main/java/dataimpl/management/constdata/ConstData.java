package dataimpl.management.constdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.ConstPO;
import dataservice.managementdataservice.constdataservice.ConstDataService;

public class ConstData implements ConstDataService {

	@Override
	public ResultMessage insert(ConstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ConstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(ConstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ConstPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstPO findByConstName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
