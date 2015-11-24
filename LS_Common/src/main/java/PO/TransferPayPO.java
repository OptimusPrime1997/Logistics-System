package PO;

public class TransferPayPO {
	private String transferRepNum;
	private String date;
	private double money;
	
	public TransferPayPO(String transferRepNum, String date, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.date = date;
		this.money = money;
	}

	public String getTransferRepNum() {
		return transferRepNum;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}
	
}
