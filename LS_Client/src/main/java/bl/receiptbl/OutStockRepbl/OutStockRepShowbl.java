package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.OutStockRepVO;

public class OutStockRepShowbl {
	
	private OutStockRepCheckbl outStockRepCheckbl = new OutStockRepCheckbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		OutStockRepVO outStockRepVO = outStockRepCheckbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < outStockRepVO.goods.size();i++){
			Vector<String> arr = new Vector<String>();
			String order = outStockRepVO.goods.get(i);
			arr.add(order);
			data.add(arr);
		}
		return data;
	}

}
