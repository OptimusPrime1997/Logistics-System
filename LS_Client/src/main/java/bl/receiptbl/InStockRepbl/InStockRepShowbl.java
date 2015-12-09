package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.InStockVO;

public class InStockRepShowbl {
	
	private InStockRepCheckbl inStockRepCheckbl = new InStockRepCheckbl();

	public Vector<Object> initShow(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		InStockRepVO inStockRepVO = inStockRepCheckbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < inStockRepVO.inStockVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			InStockVO inStockVO = inStockRepVO.inStockVOs.get(i);
			arr.add(inStockVO.order);
			arr.add(inStockVO.area);
			arr.add(inStockVO.loc);
			data.add(arr);
		}
		return data;
	}

}
