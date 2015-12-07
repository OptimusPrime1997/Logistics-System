package bl.receiptbl.DocumentCheckbl;

import java.util.Vector;

import VO.ReceiptVO.ReceiptVO;
import blservice.receiptblservice.DocumentCheckblService;
import util.enumData.Rep;

public class DocumentCheckController implements DocumentCheckblService{
	DocumentCheckbl documentCheckbl = new DocumentCheckbl();

	@Override
	public String saveRep(ReceiptVO vo, Rep rep) {
		// TODO Auto-generated method stub
		return documentCheckbl.saveRep(vo, rep);
	}

	@Override
	public Vector<Object> checkAllRep() {
		// TODO Auto-generated method stub
		return documentCheckbl.checkAllRep();
	}

}
