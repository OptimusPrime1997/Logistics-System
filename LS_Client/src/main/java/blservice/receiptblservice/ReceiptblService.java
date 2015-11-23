package blservice.receiptblservice;

import util.enumData.*;

public interface ReceiptblService {
	
	public ResultMessage addLog(String operationName, String operatorID, String time);
	
	public String getDate();
	
}
