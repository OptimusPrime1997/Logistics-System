package PO.Receipt;

import java.io.Serializable;

public class PayPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041142535900947143L;
	
	private String payThing;
	private double money;
	private String bankAccountNum;
	private String remark;
	public PayPO(String payThing, double money, String bankAccountNum, String remark) {
		super();
		this.payThing = payThing;
		this.money = money;
		this.bankAccountNum = bankAccountNum;
		this.remark = remark;
	}
	public String getPayThing() {
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
