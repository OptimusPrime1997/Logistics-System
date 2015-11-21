package bl.receiptbl.Receiptbl;

import java.util.ArrayList;

import VO.ReceiptVO;
import VO.ReceptionRepVO;
import blservice.receiptblservice.ReceiptblService;
import util.enumData.Rep;

public class ReceiptController implements ReceiptblService{
	Receiptbl receipt = new Receiptbl();

	public String delete(Rep rep, int n) {
		// TODO Auto-generated method stub
		return receipt.delete(rep, n);
	}

	public String delete(Rep rep, String num) {
		// TODO Auto-generated method stub
		return receipt.delete(rep, num);
	}

	public ReceiptVO show(Rep rep) {
		// TODO Auto-generated method stub
		return receipt.show(rep);
	}

	public ReceiptVO find(Rep rep, String num) {
		// TODO Auto-generated method stub
		return receipt.find(rep, num);
	}

	public void addLog(String operationName, String operatorID, String time) {
		// TODO Auto-generated method stub
		
	}

}
