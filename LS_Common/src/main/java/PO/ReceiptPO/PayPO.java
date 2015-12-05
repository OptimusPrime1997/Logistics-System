package PO.ReceiptPO;

import util.enumData.PayThing;

public class PayPO {
	private PayThing payThing;
	private double money;
	private String bankAccountNum;
	private String remark;
	public PayPO(PayThing payThing, double money, String bankAccountNum, String remark) {
		super();
		this.payThing = payThing;
		this.money = money;
		this.bankAccountNum = bankAccountNum;
		this.remark = remark;
	}
	public PayThing getPayThing() {
		return payThing;
	}
	public double getMoney() {
		return money;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public String getRemark() {
		return remark;
	}
	
}
