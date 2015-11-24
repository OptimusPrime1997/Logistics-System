package PO;

public class LittleThingPO {
	private String date;
	private String reason;
	private double money;
	
	public LittleThingPO(String date, String reason, double money) {
		super();
		this.date = date;
		this.reason = reason;
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public String getReason() {
		return reason;
	}

	public double getMoney() {
		return money;
	}
	
}