package bl.receiptbl.PayRepbl;

import java.util.ArrayList;

import VO.PayRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;

public class PayRepbl extends ReceiptblController{

	public ArrayList<PayRepVO> get() {
		return null;
	}

	//调用其他的forpay
	public ArrayList<ReceiptVO> forPay() {
		// TODO Auto-generated method stub
		return null;
	}

	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<PayRepVO> getAllPayRep(){
		return null;
	}
}
