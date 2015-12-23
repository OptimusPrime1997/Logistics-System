package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface NotForCashblService {
	
	/**提交单据
	 * @param vo
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws GoodsNotFound 
	 * @throws ClassNotFoundException
	 */
	public void submit(ReceiptVO vo) throws NotBoundException, IOException;
	
	/**根据单据编号初始化单据检查表格
	 * @param num
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
}
