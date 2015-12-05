package blservice.managementblservice.constblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.Const;
import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import VO.ManagementVO.ConstVO;

public interface ConstBLService {
	public ResultMessage insert(ConstVO VO)throws RemoteException;
	public ResultMessage update(ConstVO VO)throws RemoteException;
	public ResultMessage delete(ConstVO VO)throws RemoteException;
	public ArrayList<ConstVO> show()throws RemoteException, ClassNotFoundException, IOException;
	public ConstVO findByCities(String twoCities)throws RemoteException, FileNotFoundException, ClassNotFoundException, ConstNotFoundException, IOException;
	
}
