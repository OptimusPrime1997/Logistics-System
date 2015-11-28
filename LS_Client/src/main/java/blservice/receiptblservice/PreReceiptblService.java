package blservice.receiptblservice;

import util.enumData.LogType;
import util.enumData.ResultMessage;

public interface PreReceiptblService {
	
	public ResultMessage addLog(LogType operationName, String operatorID, String time);
	
	public String getDate();

}
