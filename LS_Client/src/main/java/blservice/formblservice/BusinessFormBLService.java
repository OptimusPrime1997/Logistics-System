package blservice.formblservice;

import util.enumData.ResultMessage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import VO.BusinessFormVO;

public interface BusinessFormBLService {
	/**
	 * return a businessForm by giving the start time and the end time you want to check
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public BusinessFormVO show(String startTime,String endTime) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	/**
	 * save the businessForm to local
	 * @param vo
	 * @return
	 */
	public ResultMessage save(BusinessFormVO vo);
}
