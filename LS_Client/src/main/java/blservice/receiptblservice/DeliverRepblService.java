package blservice.receiptblservice;

import Exception.GoodsNotFound;
import util.enumData.ResultMessage;

public interface DeliverRepblService extends ReceiptblService{
	public ResultMessage checkCourierNum(String string);
	
	public String getNameByOrder(String order) throws GoodsNotFound;
	
	public String getPhoneByOrder(String order) throws GoodsNotFound;
	
	public String getAddressByOrder(String order) throws GoodsNotFound;
}
