package blservice.receiptblservice;

import java.util.ArrayList;

import VO.PayRepVO;
import VO.ReceiptVO;

public interface PayRepblService extends ReceiptblService{
	public ArrayList<ReceiptVO> forPay();
	
}

