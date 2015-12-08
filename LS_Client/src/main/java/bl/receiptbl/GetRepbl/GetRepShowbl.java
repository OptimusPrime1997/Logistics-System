package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.ArriveRepPO;
import PO.ReceiptPO.DeliverRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ArriveVO;
import VO.ReceiptVO.DeliverRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class GetRepShowbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.GetRep);
		ArriveRepVO arriveRepVO = new ArriveRepVO((ArriveRepPO)receiptPO);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i<arriveRepVO.arriveVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			ArriveVO arriveVO = arriveRepVO.arriveVOs.get(i);
			arr.add(arriveVO.order);
			arr.add(arriveVO.goodsArrivalState);
			data.add(arr);
		}
		return data;
	}

}
