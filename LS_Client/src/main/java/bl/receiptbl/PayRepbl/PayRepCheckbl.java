package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class PayRepCheckbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public PayRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.PayRep);
		return new PayRepVO((PayRepPO) receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.PayRep);
		ArrayList<PayRepVO> payRepVOs = PayRepVO.toArrayVO(receiptPOs);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < payRepVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			PayRepVO payRepVO = payRepVOs.get(i);
			arr.add(payRepVO.date);
			arr.add(payRepVO.num);
			arr.add(payRepVO.sum);
			data.add(arr);
		}
		return data;
	}

}
