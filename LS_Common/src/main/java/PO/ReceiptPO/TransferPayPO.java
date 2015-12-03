package PO.ReceiptPO;

public class TransferPayPO {
	private String transferRepNum;
	private double money;
	public TransferPayPO(String transferRepNum, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.money = money;
	}
	public String getTransferRepNum() {
		return transferRepNum;
	}
	public double getMoney() {
		return money;
	}
	
}
