package blservice.receiptblservice;

public interface ShippingRepblService extends ReceiptblService{
	/**
	 * 通过中转中心编号,日期得到装车单总数
	 * @param str
	 * @return
	 */
	public int getSumByTrsOfficeNum(String str,String date);
}
