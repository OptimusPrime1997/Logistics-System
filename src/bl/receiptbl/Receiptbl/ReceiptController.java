package bl.receiptbl.Receiptbl;

import VO.ReceiptVO;
import blservice.receiptblservice.ReceiptblService;
import util.enumData.Rep;

public class ReceiptController implements ReceiptblService{
	Receiptbl receipt = new Receiptbl();

	@Override
	public void addLog(String operationName, String operatorID, String time){
		receipt.addLog(operationName, operatorID, time);
	}

	@Override
	public String delete(Rep rep, int n) {
		// TODO Auto-generated method stub
		return receipt.delete(rep, n);
	}

	@Override
	public String delete(Rep rep, String num) {
		// TODO Auto-generated method stub
		return receipt.delete(rep, num);
	}

	@Override
	public ReceiptVO show(Rep rep) {
		// TODO Auto-generated method stub
		return receipt.show(rep);
	}

	@Override
	public ReceiptVO find(Rep rep, String num) {
		// TODO Auto-generated method stub
		return receipt.find(rep, num);
	}
}
