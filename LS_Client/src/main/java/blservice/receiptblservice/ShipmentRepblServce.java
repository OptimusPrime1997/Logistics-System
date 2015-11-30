package blservice.receiptblservice;

import VO.ShipmentRepVO;

public interface ShipmentRepblServce extends ReceiptblService{
	
	public ShipmentRepVO getShipmentRep(String num);
	
}
