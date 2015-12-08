package blservice.receiptblservice;

import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.TransferRepVO;

public interface ReceptionRepblService extends ReceiptblService{
	
	ShipmentRepVO getShipmentRep(String num);

	TransferRepVO getTransferRep(String num);
}
