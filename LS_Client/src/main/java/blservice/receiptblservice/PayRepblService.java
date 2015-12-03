package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceiptVO.ReceiptVO;

public interface PayRepblService extends ReceiptblService{
	public ArrayList<ReceiptVO> forPay();
	
}

