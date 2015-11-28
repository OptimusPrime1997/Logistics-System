package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ShipmentRepVO;

public interface ShipmentRepblServce extends ReceiptblService{
	public ShipmentRepVO getShipmentRep(String num);
	
	public ArrayList<ShipmentRepVO> forpay();
}
