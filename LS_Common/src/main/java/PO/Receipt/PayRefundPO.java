package PO.Receipt;

import java.io.Serializable;

public class PayRefundPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6538456252152098312L;
	
	private String reason;
	private double money;
	
	public PayRefundPO(String reason, double money) {
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