package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceiptVO.ReceiptVO;

public interface DocumentCheckblService {
	
	public ArrayList<ReceiptVO> getRep ();
	
	public String saveRep (ReceiptVO vo);

}
