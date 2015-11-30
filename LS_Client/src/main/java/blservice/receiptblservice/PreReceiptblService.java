package blservice.receiptblservice;

import util.enumData.LogType;

public interface PreReceiptblService {
	
	public void addLog(LogType operationName, String operatorID, String time);
	
	public String getDate();

}
