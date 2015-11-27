package blservice.formblservice;

import util.enumData.ResultMessage;

import java.rmi.RemoteException;

import VO.ProfitFormVO;

public interface ProfitFormBLService {
	/**
	 * return a profitForm.
	 * @return
	 * @throws RemoteException 
	 */
	public ProfitFormVO show() throws RemoteException;
	/**
	 * save the profitForm the local
	 * @param vo
	 * @return
	 */
	public ResultMessage save(ProfitFormVO vo);
	
	
}
