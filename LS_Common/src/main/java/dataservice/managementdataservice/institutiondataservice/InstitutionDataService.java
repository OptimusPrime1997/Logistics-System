package dataservice.managementdataservice.institutiondataservice;


import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import util.enumData.ResultMessage;
import PO.InstitutionPO;

public interface InstitutionDataService {
	public ResultMessage insert(InstitutionPO po) throws RemoteException;

	public ResultMessage update(InstitutionPO po) throws RemoteException;

	public ResultMessage delete(InstitutionPO po) throws RemoteException;

	public ArrayList<InstitutionPO> show() throws RemoteException;

	public InstitutionPO findByName(String name) throws RemoteException, FileNotFoundException, NameNotFoundException;

}
