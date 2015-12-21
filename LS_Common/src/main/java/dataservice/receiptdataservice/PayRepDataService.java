package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.Receipt.PayRepPO;

/**
 * @author bismuth
 *
 */
public interface PayRepDataService extends Remote,Serializable{
	
	/**得到未提交的付款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public PayRepPO getSubmitPayRep() throws ClassNotFoundException, IOException;
	
	/**清空提交文件
	 * @throws IOException
	 */
	public void clearPaySubmit() throws IOException;
	
	/**得到所有付款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<PayRepPO> getAllPayRep() throws ClassNotFoundException, IOException;
}	
