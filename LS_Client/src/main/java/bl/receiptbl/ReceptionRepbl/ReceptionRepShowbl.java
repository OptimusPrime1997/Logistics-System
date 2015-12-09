package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ArriveVO;

public class ReceptionRepShowbl {
	
	private ReceptionRepCheckbl receptionRepCheckbl = new ReceptionRepCheckbl();

	public Vector<Object> initShow(String num)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArriveRepVO arriveRepVO = receptionRepCheckbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < arriveRepVO.arriveVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			ArriveVO arriveVO = arriveRepVO.arriveVOs.get(i);
			arr.add(arriveVO.order);
			arr.add(arriveVO.goodsArrivalState);
			data.add(arr);
		}
		return data;
	}

}
