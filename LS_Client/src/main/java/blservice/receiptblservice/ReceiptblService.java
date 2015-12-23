package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface ReceiptblService extends PreReceiptblService{
	
	/**根据单据编号得到该单据
	 * @param num
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public <T extends ReceiptVO> T getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException;
	
	
}
