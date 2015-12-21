package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;

/**
 * @author bismuth
 *
 */
public interface OutStockRepDataService extends Remote,Serializable{

	/**根据日期得到所有出库单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException;
}
