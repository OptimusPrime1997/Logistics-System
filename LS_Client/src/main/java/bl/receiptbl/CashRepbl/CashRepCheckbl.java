package bl.receiptbl.CashRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class CashRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> checkAll() throws ClassNotFoundException, NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.CashRep);
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		Vector<Object> data = new Vector<Object>();
		for (int i = 0; i < cashRepVOs.size(); i++) {
			CashRepVO cashRepVO = cashRepVOs.get(i);
			ArrayList<CashVO> cashVOs = cashRepVO.cashVOs;
			for (int k = 0; k < cashVOs.size(); k++) {
				Vector<Object> arr = new Vector<Object>();
				CashVO cashVO = cashVOs.get(k);
				arr.add(cashRepVO.date);
				arr.add(cashRepVO.num);
				arr.add(cashVO.courierNum);
				arr.add(cashVO.courierName);
				arr.add(cashVO.money);
				data.add(arr);
			}
		}
		return data;
	}
	
}
