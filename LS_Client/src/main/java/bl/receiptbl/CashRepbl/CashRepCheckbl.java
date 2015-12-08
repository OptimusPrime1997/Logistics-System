package bl.receiptbl.CashRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class CashRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.CashRep);
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		Vector<Object> data = new Vector<Object>();
		for (int i = 0; i < cashRepVOs.size(); i++) {
			CashRepVO cashRepVO = cashRepVOs.get(i);
			Vector<Object> arr = new Vector<Object>();
			arr.add(cashRepVO.date);
			arr.add(cashRepVO.num);
			arr.add(cashRepVO.sum);
			arr.add(cashRepVO.bankAccount);
			data.add(arr);
		}
		return data;
	}

	public CashRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.CashRep);
		return new CashRepVO((CashRepPO)receiptPO);
	}
}
