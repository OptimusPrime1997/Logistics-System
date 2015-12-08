package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class InStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();

	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.InStockRep);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(InStockRepVO.toPO((InStockRepVO) vo), Rep.InStockRep);
	}

	public ArrayList<InStockRepVO> getRepByDate(String date) throws ClassNotFoundException, 
	NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.InStockRep);
		if(receiptPOs==null)
			return null;
		return InStockRepVO.toArrayVO(receiptPOs);
	}

}
