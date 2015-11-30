package blservice.receiptblservice;

import VO.TransferRepVO;

public interface TransferRepblService extends ReceiptblService{
	
	public TransferRepVO getTransferRep(String num);

}
