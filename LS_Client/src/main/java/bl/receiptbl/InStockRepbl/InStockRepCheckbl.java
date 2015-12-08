package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class InStockRepCheckbl {
	
	private Receiptbl receiptbl = new Receiptbl();

	public InStockRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.InStockRep);
		return new InStockRepVO((InStockRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.InStockRep);
		ArrayList<InStockRepVO> inStockRepVOs = InStockRepVO.toArrayVO(receiptPOs);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < inStockRepVOs.size();i++){
			InStockRepVO inStockRepVO = inStockRepVOs.get(i);
			Vector<Object> arr = new Vector<Object>();
			arr.add(inStockRepVO.date);
			arr.add(inStockRepVO.num);
			data.add(arr);
		}
		return data;
	}

}
