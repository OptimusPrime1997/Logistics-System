package PO.ReceiptPO;

public class LittleThingPO {
	private String reason;
	private double money;
	
	public LittleThingPO(String reason, double money) {
		super();
		this.reason = reason;
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public double getMoney() {
		return money;
	}
	
}