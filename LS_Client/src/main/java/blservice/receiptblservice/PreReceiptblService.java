package blservice.receiptblservice;

import util.enumData.LogType;
import util.enumData.ResultMessage;

public interface PreReceiptblService {
	
	public void addLog(LogType operationName, String operatorID, String time);
	
	public String getDate();

	public String getDateInNum(String string);
	
	public ResultMessage checkNum(String string, int n);
}
