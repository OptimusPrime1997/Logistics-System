package bl.receiptbl.DocumentCheckbl;

import java.util.ArrayList;

import VO.ReceiptVO.ReceiptVO;
import blservice.receiptblservice.DocumentCheckblService;

public class DocumentCheckController implements DocumentCheckblService{
	DocumentCheckbl DocumentCheck = new DocumentCheckbl();

	public ArrayList<ReceiptVO> getRep() {
		// TODO Auto-generated method stub
		return DocumentCheck.getRep();
	}

	public String saveRep(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return DocumentCheck.saveRep(vo);
	}

}
