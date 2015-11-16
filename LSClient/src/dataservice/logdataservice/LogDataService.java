package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.logbl.LogType;
import PO.LogPO;
import VO.LogVO;
/**
 * add or check the system log
 * @author Administrator
 *
 */
public interface LogDataService {
	public ArrayList<LogVO> show(LogType type)throws RemoteException;
	public void add(LogPO po)throws RemoteException;
}
