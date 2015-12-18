package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRepVO;

public class PayRepCheckbl {
	
	private PayRepbl payRepbl = new PayRepbl();

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<PayRepVO> payRepVOs = payRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < payRepVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			PayRepVO payRepVO = payRepVOs.get(i);
			arr.add(payRepVO.date);
			arr.add(payRepVO.sum+"");
			data.add(arr);
		}
		return data;
	}

}
