package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.Receipt.InStockRepPO;
import PO.Receipt.ReceiptPO;
import VO.Receipt.InStockRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class InStockRepCheckbl {
	
	private Receiptbl receiptbl = new Receiptbl();
	private InStockRepbl inStockRepbl = new InStockRepbl();

	public InStockRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.InStockRep);
		return new InStockRepVO((InStockRepPO)receiptPO);
	}

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<InStockRepVO> inStockRepVOs = inStockRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		if(inStockRepVOs==null)
			return null;
		for(int i = 0;i < inStockRepVOs.size();i++){
			InStockRepVO inStockRepVO = inStockRepVOs.get(i);
			Vector<String> arr = new Vector<String>();
			arr.add(inStockRepVO.date);
			arr.add(inStockRepVO.num);
			data.add(arr);
		}
		return data;
	}

}
