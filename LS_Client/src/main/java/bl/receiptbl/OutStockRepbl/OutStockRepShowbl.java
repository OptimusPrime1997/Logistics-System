package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.OutStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.GoodsVO;
import VO.ReceiptVO.OutStockRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class OutStockRepShowbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.OutStockRep);
		OutStockRepVO outStockRepVO = new OutStockRepVO((OutStockRepPO)receiptPO);
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
