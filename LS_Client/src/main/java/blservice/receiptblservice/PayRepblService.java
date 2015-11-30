package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceiptVO;

public interface PayRepblService extends ReceiptblService{
	public ArrayList<ReceiptVO> forPay();
	
}

