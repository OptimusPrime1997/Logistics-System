package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

/**
 * @author bismuth
 *
 */
public interface ShipmentRepblServce extends ReceiptblService, NotForPayblService, NotForCashblService, NotForPayAndCashblService{
	
	/**得到该日期内的出车总数
	 * @param date
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public String getTruckSum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException;
	
	/**是否存在该账户
	 * @param num
	 * @return
	 */
	public boolean isTrueAccount(String num);
	
	/**是否存在该订单
	 * @param order
	 * @return
	 */
	public boolean isTrueOrder(String order);
	
}
