package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

/**
 * @author bismuth
 *
 */
public interface PostReceiptblService {

	/**根据工作地点得到所有单据
	 * @param office
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public <T extends ReceiptVO> ArrayList<T> getAllRep(String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	/**根据工作地点和日期得到所有单据
	 * @param date
	 * @param office
	 * @return
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public <T extends ReceiptVO> ArrayList<T> getRepByDate(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	/**根据工作地点初始化查看表格
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NameNotFoundException
	 * @throws NumNotFoundException
	 */
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException, NameNotFoundException, NumNotFoundException;
}
