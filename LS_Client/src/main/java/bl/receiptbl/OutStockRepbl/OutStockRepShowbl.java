package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;
import VO.ReceiptVO.OutStockRepVO;

public class OutStockRepShowbl {
	
	private OutStockRepCheckbl outStockRepCheckbl = new OutStockRepCheckbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		OutStockRepVO outStockRepVO = outStockRepCheckbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < outStockRepVO.goods.size();i++){
			Vector<Object> arr = new Vector<Object>();
			String order = outStockRepVO.goods.get(i);
			arr.add(order);
			data.add(arr);
		}
		return data;
	}

}
