package bl.receiptbl.Receiptbl;

import blservice.receiptblservice.PreReceiptblService;
import util.enumData.*;

public class ReceiptblController implements PreReceiptblService{
	
	Receiptbl receiptbl = new Receiptbl();

	public ResultMessage addLog(LogType operationName, String operatorID, String time){
		return receiptbl.addLog(operationName, operatorID, time);
	}
	
	public String getDate(){
		return receiptbl.getDate();
	}

}
