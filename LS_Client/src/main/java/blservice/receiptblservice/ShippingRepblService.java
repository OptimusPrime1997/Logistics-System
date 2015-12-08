package blservice.receiptblservice;

import VO.ReceiptVO.ShippingRepVO;

public interface ShippingRepblService extends ReceiptblService{
	
	public ShippingRepVO getShippingRep(String num);
	
	public int getTruckNum(String date);

}
