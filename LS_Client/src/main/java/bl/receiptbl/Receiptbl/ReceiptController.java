package bl.receiptbl.Receiptbl;

import blservice.receiptblservice.ReceiptblService;
import util.enumData.*;

public class ReceiptController implements ReceiptblService{
	Receiptbl receipt = new Receiptbl();
	
	@Override
	public ResultMessage addLog(String operationName, String operatorID, String time) {
		// TODO Auto-generated method stub
		return receipt.addLog(operationName, operatorID, time);
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return receipt.getDate();
	}

}
