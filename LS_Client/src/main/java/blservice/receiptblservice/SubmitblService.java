package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface SubmitblService {
	
	/**提交单据
	 * @param vo
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void submit(ReceiptVO vo) throws NotBoundException, IOException, ClassNotFoundException;
}
