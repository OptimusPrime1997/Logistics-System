package bl.receiptbl.controller.receiptcontroller;

import bl.receiptbl.CashRepblImpl;
import blservice.receiptblservice.CashRepblService;

public class CashRepController extends ReceiptController{
	private CashRepblService CashRep = new CashRepblImpl();
	public String submit(String num, String date, double money, String getCourierNum){
		return CashRep.submit(num, date, money, getCourierNum);
	}
}
