package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import PO.ReceiptPO.ArriveRepPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ArriveVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.InStockVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class InStockRepShowbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.InStockRep);
		InStockRepVO inStockRepVO = new InStockRepVO((InStockRepPO)receiptPO);
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
