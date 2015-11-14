package VO.ManagementVO;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionPO;

public interface InstitutionDataService {
	public void insert(InstitutionPO po) throws RemoteException;

	public void update(InstitutionPO po) throws RemoteException;

	public void delete(InstitutionPO po) throws RemoteException;

	public ArrayList<InstitutionPO> show() throws RemoteException;

	public InstitutionPO findByName(String name) throws RemoteException;

}
