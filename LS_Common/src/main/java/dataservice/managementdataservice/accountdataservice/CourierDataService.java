package dataservice.managementdataservice.accountdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.AccountPO;
import PO.CourierPO;

public interface CourierDataService extends Remote {
	public ResultMessage insert(CourierPO po) throws RemoteException,
			IOException;

	public ResultMessage update(CourierPO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ResultMessage delete(CourierPO po) throws RemoteException,
			ClassNotFoundException, IOException;

	public ArrayList<CourierPO> show() throws RemoteException,
			ClassNotFoundException, IOException;

	public CourierPO findByCourierNum(String accountNum)
			throws RemoteException, FileNotFoundException,
			NumNotFoundException, ClassNotFoundException, IOException;

}
