package PO.Receipt;

import java.io.Serializable;

public class PayRentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7981311473165057354L;
	
	private String getterName;
	private String phoneNum;
	private double money;
	private String remark;
	public PayRentPO(String getterName, String phoneNum, double money, String remark) {
		super();
		this.getterName = getterName;
		this.phoneNum = phoneNum;
		this.money = money;
		this.remark = remark;
	}
	public String getGetterName() {
		return getterName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public double getMoney() {
		return money;
	}
	public String getRemark() {
		return remark;
	}
	
}