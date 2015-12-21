package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface ReceiptblService extends PreReceiptblService{
	
	/**根据工作地点自动生成编号
	 * @param date
	 * @param office
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	/**根据单据编号得到该单据
	 * @param num
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public <T extends ReceiptVO> T getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException;
	
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
