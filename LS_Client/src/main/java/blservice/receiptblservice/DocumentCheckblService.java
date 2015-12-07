package blservice.receiptblservice;

import java.util.Vector;

import VO.ReceiptVO.ReceiptVO;
import util.enumData.Rep;

public interface DocumentCheckblService {
	
	public String saveRep (ReceiptVO vo, Rep rep);
	
	public Vector<Object> checkAllRep();

}
