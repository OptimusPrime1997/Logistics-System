package bl.receiptbl.controller.receiptcontroller;

import VO.LogVO;
import bl.logbl.Logbl;

public class ReceiptController {

	public void addLog(String operationName, String operatorID, String time){
		LogVO log = new LogVO(operationName, operatorID, time);
		Logbl logbl = new Logbl();
		logbl.add(log);
	}
}
