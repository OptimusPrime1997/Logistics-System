package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class PayRepShowbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.PayRep);
		PayRepVO payRepVO = new PayRepVO((PayRepPO)receiptPO);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < payRepVO.payVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			PayVO payVO = payRepVO.payVOs.get(i);
			arr.add(payVO.payThing);
			arr.add(payVO.money);
			arr.add(payVO.bankAccountNum);
			arr.add(payVO.remark);
			data.add(arr);
		}
		return data;
	}

}
