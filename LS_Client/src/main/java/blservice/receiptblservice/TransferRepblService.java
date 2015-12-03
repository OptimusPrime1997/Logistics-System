package blservice.receiptblservice;

import VO.ReceiptVO.TransferRepVO;

public interface TransferRepblService extends ReceiptblService{
	
	public TransferRepVO getTransferRep(String num);

}
