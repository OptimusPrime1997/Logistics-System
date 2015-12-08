package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import util.enumData.Rep;

public class PayRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.PayRep);
	}

	public void submit(ReceiptVO vo) throws IOException, NotBoundException {
		// TODO Auto-generated method stub
		receiptbl.submit(PayRepVO.toPO((PayRepVO) vo), Rep.PayRep);
	}
	
}
