package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.Receipt.PayRepPO;

/**
 * @author bismuth
 *
 */
public interface PayRepDataService extends Remote, Serializable{
	
	/**得到未提交的付款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public PayRepPO getSubmitPayRep() throws ClassNotFoundException, IOException;
	
	/**清空提交文件
	 * @throws IOException
	 */
	public void clearPaySubmit() throws IOException, RemoteException;
	
	/**得到所有付款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<PayRepPO> getAllPayRep() throws ClassNotFoundException, IOException;
	
	/**通过编号得到一个付款单
	 * @param num
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public PayRepPO getPayRepByNum(String num) throws ClassNotFoundException, IOException;
}	
