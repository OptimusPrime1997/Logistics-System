package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.TransferRepPO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import util.enumData.Rep;

public class TransferRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.TransferRep);
	}

	public TransferRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.TransferRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new TransferRepVO((TransferRepPO)receiptPO);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(TransferRepVO.toPO((TransferRepVO) vo), Rep.TransferRep);
	}

	public ArrayList<TransferRepVO> getAllRep() 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.TransferRep);
		return TransferRepVO.toArrayVO(receiptPOs);
	}

}
