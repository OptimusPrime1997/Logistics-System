package blservice.receiptblservice;

import java.util.ArrayList;

import VO.PayRepVO;
import VO.ReceiptVO;

public interface PayRepblService extends ReceiptblService{
	public ArrayList<ReceiptVO> forPay();
	
//	public String getBankAccount (ArrayList<BankAccountVO>);
	
	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent);
}

