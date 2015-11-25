package blservice.receiptblservice;

import util.enumData.ResultMessage;

public interface PreReceiptblService {
	
	public ResultMessage addLog(String operationName, String operatorID, String time);
	
	public String getDate();

}
