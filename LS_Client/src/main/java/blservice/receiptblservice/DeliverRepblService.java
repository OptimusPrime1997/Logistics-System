package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import Exception.GoodsNotFound;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;

/**
 * @author bismuth
 *
 */
public interface DeliverRepblService extends ReceiptblService, NotForPayblService, NotForCashblService, NotForPayAndCashblService{
	
	/**通过订单号得到收件人名字
	 * @param order
	 * @return
	 * @throws GoodsNotFound
	 */
	public String getNameByOrder(String order) throws GoodsNotFound;
	
	/**通过订单号得到收件人手机号
	 * @param order
	 * @return
	 * @throws GoodsNotFound
	 */
	public String getPhoneByOrder(String order) throws GoodsNotFound;
	
	/**通过订单号得到收件人地址
	 * @param order
	 * @return
	 * @throws GoodsNotFound
	 */
	public String getAddressByOrder(String order) throws GoodsNotFound;
	
	/**通过快递员编号得到快递员名字
	 * @param courierNum
	 * @return
	 * @throws RemoteException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NameNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public String getCourierName(String courierNum) throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException,NumNotFoundException, IOException;
	
	/**检查快递员编号是否存在
	 * @param num
	 * @return
	 */
	public boolean isTrueAccount(String num);
	
	/**改变物流状态
	 * @param num
	 */
	public void changeLogistic(String num);
}
