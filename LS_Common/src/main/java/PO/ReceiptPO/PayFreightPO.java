package PO.ReceiptPO;

import java.io.Serializable;

public class PayFreightPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3373380111655088258L;
	
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
