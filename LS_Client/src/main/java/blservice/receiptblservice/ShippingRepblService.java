package blservice.receiptblservice;

/**
 * @author bismuth
 *
 */
public interface ShippingRepblService extends ReceiptblService{
	
	/**是否存在该订单
	 * @param order
	 * @return
	 */
	public boolean isTrueOrder(String order);
	
	/**是否存在该账户
	 * @param num
	 * @return
	 */
	public boolean isTrueAccount(String num);
}
