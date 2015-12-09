package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.OutStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.OutStockRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class OutStockRepCheckbl {
	
	private Receiptbl receiptbl = new Receiptbl();
	private OutStockRepbl outStockRepbl = new OutStockRepbl();

	public OutStockRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.OutStockRep);
		return new OutStockRepVO((OutStockRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<OutStockRepVO> outStockRepVOs = outStockRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < outStockRepVOs.size();i++){
			OutStockRepVO outStockRepVO = outStockRepVOs.get(i);
			Vector<Object> arr = new Vector<Object>();
			arr.add(outStockRepVO.date);
			arr.add(outStockRepVO.num);
			arr.add(outStockRepVO.rep);
			arr.add(outStockRepVO.num);
<<<<<<< HEAD
			arr.add(outStockRepVO.city);
=======
			arr.add(outStockRepVO.destination);
>>>>>>> origin/master
			arr.add(outStockRepVO.form);
			data.add(arr);
		}
		return data;
	}

}
