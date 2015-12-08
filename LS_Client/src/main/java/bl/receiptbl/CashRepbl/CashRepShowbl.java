package bl.receiptbl.CashRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class CashRepShowbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, 
	NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.CashRep);
		CashRepVO cashRepVO = new CashRepVO((CashRepPO)receiptPO);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < cashRepVO.cashVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			CashVO cashVO = cashRepVO.cashVOs.get(i);
			arr.add(cashVO.courierName);
			arr.add(cashVO.courierNum);
			arr.add(cashVO.money);
			arr.add(cashVO.remark);
			data.add(arr);
		}
		return data;
	}
	
}
