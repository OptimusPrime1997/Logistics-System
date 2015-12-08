package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ArriveVO;

public class GetRepShowbl {
	
	private GetRepCheckbl getRepCheckbl = new GetRepCheckbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArriveRepVO arriveRepVO = getRepCheckbl.getRepByNum(num);
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
