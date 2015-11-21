package bl.receiptbl.PayRepbl;

import java.util.ArrayList;

import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.PayRepblService;

public class PayRepController extends ReceiptController implements PayRepblService{
	PayRepbl PayRep = new PayRepbl();

	public ArrayList<ReceiptVO> forPay() {
		// TODO Auto-generated method stub
		return PayRep.forPay();
	}

	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		// TODO Auto-generated method stub
		return PayRep.submit(num, date, bankAccountNum, payPersonNum, payThings, salary, transferPay, rent);
	}


}
