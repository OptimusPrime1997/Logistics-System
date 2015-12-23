package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;

/**
 * @author bismuth
 *
 */
public interface CashRepDataService extends Remote,Serializable{
	
	/**根据日期得到所有收款单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException;
	
	/**得到所有收款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<ReceiptPO> getAllRep() throws ClassNotFoundException, IOException;
}