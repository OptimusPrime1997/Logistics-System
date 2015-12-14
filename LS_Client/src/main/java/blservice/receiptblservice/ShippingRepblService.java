package blservice.receiptblservice;

import util.enumData.ResultMessage;

public interface ShippingRepblService extends ReceiptblService{
	public ResultMessage checkDriverNum(String string);
}
