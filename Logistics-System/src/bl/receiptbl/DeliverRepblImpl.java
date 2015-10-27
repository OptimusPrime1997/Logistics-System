package bl.receiptbl;

import java.util.ArrayList;

import VO.DeliverRepVO;
import blservice.receiptblservice.DeliverRepblService;

public class DeliverRepblImpl extends ReceiptRepblImpl implements DeliverRepblService{
	public ArrayList<DeliverRepVO> forPay(){
		return null;
	}
	
	@Override
	public String submit(String num, String date, String deliverCourierNum, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}
}
