package dataservice.managementdataservice.constdataservice;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import PO.ConstPO;

public interface ConstDataService {
	public ResultMessage insert(ConstPO po)throws RemoteException;
	public ResultMessage update(ConstPO po)throws RemoteException;
	public ResultMessage delete(ConstPO po)throws RemoteException;
	public ArrayList<ConstPO> show()throws RemoteException;
	public ConstPO findByCities(String cities)throws RemoteException, FileNotFoundException, ConstNotFoundException;
	
}
