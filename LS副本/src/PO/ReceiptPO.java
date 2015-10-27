package PO;

public class ReceiptPO {
	protected String num;
	protected String date;
	
	public ReceiptPO(String num, String date) {
		this.num = num;
		this.date = date;
	}
	
	public String getNum() {
		return num;
	}
	public String getDate() {
		return date;
	}
	

}
