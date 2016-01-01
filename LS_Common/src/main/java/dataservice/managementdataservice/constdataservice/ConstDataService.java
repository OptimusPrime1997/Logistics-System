package dataservice.managementdataservice.constdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.City;
import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import PO.ConstPO;

public interface ConstDataService extends Remote{
	public ResultMessage insert(ConstPO po)throws RemoteException, IOException;
	public ResultMessage update(ConstPO po)throws RemoteException, ClassNotFoundException, IOException;
	public ResultMessage delete(ConstPO po)throws RemoteException, ClassNotFoundException, IOException;
	public ArrayList<ConstPO> show()throws RemoteException, ClassNotFoundException, IOException;
	public ConstPO findByCities(City c1,City c2)throws RemoteException, FileNotFoundException, ConstNotFoundException, ClassNotFoundException, IOException;
	
}
