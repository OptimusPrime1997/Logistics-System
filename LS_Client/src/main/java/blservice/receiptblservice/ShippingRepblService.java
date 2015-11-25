package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ShippingRepVO;

public interface ShippingRepblService extends ReceiptblService{
	public ShippingRepVO getShippingRep(String num);

	public ArrayList<ShippingRepVO> forpay();
}
