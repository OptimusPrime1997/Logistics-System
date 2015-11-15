
package blservice.managementblservice.institutionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.InstitutionVO;

public interface InstitutionBLService {
	public String insert(InstitutionVO VO)throws RemoteException;
	public String update(InstitutionVO VO)throws RemoteException;
	public String delete(InstitutionVO VO)throws RemoteException;
	public ArrayList<InstitutionVO> show()throws RemoteException;
	public InstitutionVO findByName(String name)throws RemoteException;
	
}

