package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.OutStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class OutStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();

	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		return receiptbl.createNum(date, Rep.OutStockRep);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(OutStockRepVO.toPO((OutStockRepVO)vo), Rep.OutStockRep);
	}

	public ArrayList<OutStockRepVO> getRepByDate(String date) throws ClassNotFoundException, 
	NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.OutStockRep);
		if(receiptPOs==null)
			return null;
		return OutStockRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<OutStockRepVO> getAllRep() throws ClassNotFoundException, NotBoundException, 
	IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.OutStockRep);
		return OutStockRepVO.toArrayVO(receiptPOs);
	}

}
