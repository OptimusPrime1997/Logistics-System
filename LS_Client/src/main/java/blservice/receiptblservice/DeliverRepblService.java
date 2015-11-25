package blservice.receiptblservice;

import java.util.ArrayList;

import VO.DeliverRepVO;

public interface DeliverRepblService extends ReceiptblService{
	public ArrayList<DeliverRepVO> forPay();
}
