package PO.ReceiptPO;

import java.io.Serializable;

public class PaySalaryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5682689079084801325L;
	
	private String getterName;
	private String getterNum;
	private double money;
	public PaySalaryPO(String getterName, String getterNum, double money) {
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.money = money;
	}
	public String getGetterName() {
		return getterName;
	}
	public String getGetterNum() {
		return getterNum;
	}
	public double getMoney() {
		return money;
	}
	
}
