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
public interface TransferRepDataService extends Remote,Serializable {

	/**得到当月所有的中转单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<ReceiptPO> getMonthRep(String date) throws ClassNotFoundException, IOException;
}
