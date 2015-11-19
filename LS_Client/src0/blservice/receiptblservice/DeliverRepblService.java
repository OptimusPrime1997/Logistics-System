package blservice.receiptblservice;

import java.util.ArrayList;

public interface DeliverRepblService extends ReceiptblService{
	public String submit(String num, String date, String deliverCourierNum, ArrayList<String> goods);
}
