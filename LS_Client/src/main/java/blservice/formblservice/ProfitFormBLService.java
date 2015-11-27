package blservice.formblservice;

import util.enumData.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import VO.ProfitFormVO;

public interface ProfitFormBLService {
	/**
	 * return a profitForm.
	 * @return
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public ProfitFormVO show() throws RemoteException, MalformedURLException, NotBoundException;
	/**
	 * save the profitForm the local
	 * @param vo
	 * @return
	 */
	public ResultMessage save(ProfitFormVO vo);
	
	
}
