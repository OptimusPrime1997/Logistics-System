package PO.ReceiptPO;

public class PayFreightPO {
	private String transferRepNum;
	private double money;
	private String remark;
	public PayFreightPO(String transferRepNum, double money, String remark) {
		super();
		this.transferRepNum = transferRepNum;
		this.money = money;
		this.remark = remark;
	}
	public String getTransferRepNum() {
		return transferRepNum;
	}
	public double getMoney() {
		return money;
	}
	public String getRemark() {
		return remark;
	}
	
}
