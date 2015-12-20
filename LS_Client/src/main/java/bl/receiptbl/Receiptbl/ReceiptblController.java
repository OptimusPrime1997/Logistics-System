package bl.receiptbl.Receiptbl;

import blservice.receiptblservice.PreReceiptblService;
import util.enumData.*;

public class ReceiptblController implements PreReceiptblService{
	
	Receiptbl receiptbl = new Receiptbl();

	@Override
	public void addLog(LogType operationName, String operatorID, String time){
		receiptbl.addLog(operationName, operatorID, time);
	}
	
	@Override
	public String getDate(){
		return receiptbl.getDate();
	}

	@Override
	public String getDateInNum(String string) {
		// TODO Auto-generated method stub
		return receiptbl.getDateInNum(string);
	}

	@Override
	public String checkNum(String string, int n, String info) {
		// TODO Auto-generated method stub
		return receiptbl.checkNum(string, n, info);
	}

}
