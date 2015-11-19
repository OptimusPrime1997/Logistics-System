package bl.receiptbl.DeliverRepbl;

import java.util.ArrayList;

import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.DeliverRepblService;

public class DeliverController extends ReceiptController implements DeliverRepblService{
	DeliverRepbl DeliverRep = new DeliverRepbl();

	@Override
	public String submit(String num, String date, String deliverCourierNum, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return DeliverRep.submit(num, date, deliverCourierNum, goods);
	}

}
