package blservice.receiptblservice;

import util.enumData.ResultMessage;

public interface DeliverRepblService extends ReceiptblService{
	public ResultMessage checkCourierNum(String string);
}
