package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface GetRepByDateblService {
	
	/**根据工作地点和日期得到所有单据
	 * @param date
	 * @param office
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public <T extends ReceiptVO> ArrayList<T> getRepByDate(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
}
