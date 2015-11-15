package blservice.receiptblservice;

public interface CashRepblService extends ReceiptblService{
	public String submit(String num, String date, double money, String getCourierNum);
}
