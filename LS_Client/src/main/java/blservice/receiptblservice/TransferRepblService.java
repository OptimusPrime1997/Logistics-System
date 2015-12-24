package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.ConstNotFoundException;
import Exception.GoodsNotFound;
import VO.Receipt.TransferRepVO;
import util.enumData.ShipForm;

/**
 * @author bismuth
 *
 */
public interface TransferRepblService extends ReceiptblService, GetRepByDateblService, NotForPayblService, NotForCashblService, NotForPayAndCashblService{
	
	/**是否存在该订单
	 * @param order
	 * @return
	 */
	public boolean isTrueOrder(String order);
	
	/**得到运费
	 * @param depart
	 * @param destination
	 * @param weight
	 * @param form
	 * @return
	 * @throws IOException 
	 * @throws ConstNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public double getFreightMoney(String depart, String destination, double weight, ShipForm form) throws FileNotFoundException, ClassNotFoundException, ConstNotFoundException, IOException;
	
	/**得到运输总重量
	 * @param order
	 * @return
	 * @throws GoodsNotFound
	 */
	public double getWeightByOrder(String order) throws GoodsNotFound;
	
	/**得到这个月的所有中转单
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public ArrayList<TransferRepVO> getMonthRep(String date) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException,NotBoundException;
}
