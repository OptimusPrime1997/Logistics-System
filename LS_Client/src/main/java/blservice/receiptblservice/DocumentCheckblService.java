package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;
import VO.Receipt.ReceiptVO;
import util.enumData.Rep;

/**
 * @author bismuth
 *
 */
public interface DocumentCheckblService {
	
	/**保存单据
	 * @param vo
	 * @param rep
	 */
	public void saveRep (ReceiptVO vo, Rep rep);
	
	/**初始化审批单据表格
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public Vector<Object> initTable() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
}
