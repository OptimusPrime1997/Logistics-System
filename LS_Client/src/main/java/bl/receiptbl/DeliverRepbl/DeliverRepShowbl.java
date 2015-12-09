package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.DeliverVO;

public class DeliverRepShowbl {
	
	private DeliverRepCheckbl deliverRepCheckbl = new DeliverRepCheckbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		DeliverRepVO deliverRepVO = deliverRepCheckbl.getRepByNum(num);
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
