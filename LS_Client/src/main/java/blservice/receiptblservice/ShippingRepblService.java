package blservice.receiptblservice;

import VO.ShippingRepVO;

public interface ShippingRepblService extends ReceiptblService{
	
	public ShippingRepVO getShippingRep(String num);

}
