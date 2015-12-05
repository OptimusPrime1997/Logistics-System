package dataservice.managementdataservice.institutiondataservice;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import PO.InstitutionPO;

public interface InstitutionDataService extends Remote{
	public ResultMessage insert(InstitutionPO po) throws RemoteException, IOException;

	public ResultMessage update(InstitutionPO po) throws RemoteException, ClassNotFoundException, IOException;

	public ResultMessage delete(InstitutionPO po) throws RemoteException, IOException, ClassNotFoundException;

	public ArrayList<InstitutionPO> show() throws RemoteException, ClassNotFoundException, IOException;

	public InstitutionPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException, ClassNotFoundException, IOException;

}
