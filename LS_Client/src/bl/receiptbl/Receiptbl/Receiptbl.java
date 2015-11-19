package bl.receiptbl.Receiptbl;

import VO.LogVO;
import VO.ReceiptVO;
import bl.logbl.Logbl;
import util.enumData.Rep;

public class Receiptbl{

	public void addLog(String operationName, String operatorID, String time){
		LogVO log = new LogVO(operationName, operatorID, time);
		Logbl logbl = new Logbl();
		logbl.add(log);
	}
	
	public String delete(Rep rep, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(Rep rep, String num) {
		// ODO Auto-generated method stub
		return null;
	}

	public ReceiptVO show(Rep rep) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiptVO find(Rep rep, String num) {
		// TODO Auto-generated method stub
		return null;
	}

}
