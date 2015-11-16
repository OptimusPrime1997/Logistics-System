package dataservice.managementdataservice.constdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import PO.ConstPO;

public interface ConstDataService {
	public ResultMessage insert(ConstPO po)throws RemoteException;
	public ResultMessage update(ConstPO po)throws RemoteException;
	public ResultMessage delete(ConstPO po)throws RemoteException;
	public ArrayList<ConstPO> show()throws RemoteException;
	public ConstPO findByConstName(String name)throws RemoteException;
	
}
