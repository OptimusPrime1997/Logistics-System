package dataservice.managementdataservice.constdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ConstPO;

public interface ConstDataService {
	public void insert(ConstPO po)throws RemoteException;
	public void update(ConstPO po)throws RemoteException;
	public void delete(ConstPO po)throws RemoteException;
	public ArrayList<ConstPO> show()throws RemoteException;
	public ConstPO findByConstName(String name)throws RemoteException;
	
}
