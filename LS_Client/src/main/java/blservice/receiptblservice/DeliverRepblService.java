package blservice.receiptblservice;

import util.enumData.ResultMessage;

public interface DeliverRepblService extends ReceiptblService{
	public ResultMessage checkOrderNum(String order);
	
	public ResultMessage checkCourierNum(String courierNum);
}
