package blservice.managementblservice.constblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ManagementVO.ConstVO;;

public interface ConstBLService {
	public String insert(ConstVO VO)throws RemoteException;
	public String update(ConstVO VO)throws RemoteException;
	public String delete(ConstVO VO)throws RemoteException;
	public ArrayList<ConstVO> show()throws RemoteException;
	public ConstVO findByConstName(String constName)throws RemoteException;
	
}
