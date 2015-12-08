package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.DeliverRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.DeliverVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class DeliverRepShowbl {
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.DeliverRep);
		DeliverRepVO deliverRepVO = new DeliverRepVO((DeliverRepPO)receiptPO);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < deliverRepVO.deliverVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			DeliverVO deliverVO = deliverRepVO.deliverVOs.get(i);
			arr.add(deliverVO.order);
			arr.add(deliverVO.receiverName);
			arr.add(deliverVO.receiverPhone);
			arr.add(deliverVO.address);
			data.add(arr);
		}
		return data;
	}

}
