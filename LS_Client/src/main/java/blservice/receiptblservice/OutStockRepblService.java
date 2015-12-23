package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;

/**
 * @author bismuth
 *
 */
public interface OutStockRepblService extends ReceiptblService, GetRepByDateblService, NotForPayblService, NotForCashblService, NotForPayAndCashblService{
	
	/**得到相应中转中心装车单
	 * @param num
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public ShippingRepVO getShippingRepVO(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	/**得到相应营业厅装车单
	 * @param num
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public TransferRepVO getTransferRepVO(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	/**根据日期得到所有出库单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public ArrayList<OutStockRepVO> getAllRepByDate(String date) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, NotBoundException;
}
