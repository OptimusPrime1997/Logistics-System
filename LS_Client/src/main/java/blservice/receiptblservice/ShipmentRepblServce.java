package blservice.receiptblservice;

import VO.ReceiptVO.ShipmentRepVO;

public interface ShipmentRepblServce extends ReceiptblService{
	
	public ShipmentRepVO getShipmentRep(String num);
	
}
