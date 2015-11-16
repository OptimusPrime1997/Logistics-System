
package blservice.managementblservice.institutionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.ManagementVO.InstitutionVO;

public interface InstitutionBLService {
	public ResultMessage insert(InstitutionVO VO)throws RemoteException;
	public ResultMessage update(InstitutionVO VO)throws RemoteException;
	public ResultMessage delete(InstitutionVO VO)throws RemoteException;
	public ArrayList<InstitutionVO> show()throws RemoteException;
	public InstitutionVO findByName(String name)throws RemoteException;
	
}

