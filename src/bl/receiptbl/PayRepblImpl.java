package bl.receiptbl;

import java.util.ArrayList;

import VO.PayRepVO;
import blservice.receiptblservice.PayRepblService;

public class PayRepblImpl extends ReceiptblImpl implements PayRepblService{

	public ArrayList<PayRepVO> get() {
		return null;
		
	}

	@Override
	public ArrayList<PayRepVO> forPay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		// TODO Auto-generated method stub
		return null;
	}
}
