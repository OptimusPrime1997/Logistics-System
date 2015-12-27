package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.GoodsNotFound;
import VO.StockDivisionVO;
import VO.Receipt.InStockRepVO;
import util.enumData.City;
import util.enumData.ResultMessage;

/**
 * @author bismuth
 *
 */
public interface InStockRepblService extends ReceiptblService, NotForPayblService, GetRepByDateblService, NotForCashblService, NotForPayAndCashblService{
	
	/**根据订单号得到目的城市
	 * @param order
	 * @return
	 * @throws GoodsNotFound
	 */
	public String getCity(String order) throws GoodsNotFound;
	
	/**得到可用位置
	 * @param des
	 * @return
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException;
	
	/**从仓库中删除该订单
	 * @param listNum
	 * @return
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws NotBoundException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(String listNum) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	/**更新库存
	 * @param vo
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException;
	
	/**根据日期得到所有入库单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public ArrayList<InStockRepVO> getAllRepByDate(String date) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, NotBoundException;
}
