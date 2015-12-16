package PO.Receipt;

import java.io.Serializable;

public class CashPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1913008501948485197L;
	private double money;
	private String courierNum;
	private String courierName;
	private String remark;
	public CashPO(double money, String courierNum, String courierName, String remark) {
		this.money = money;
		this.courierNum = courierNum;
		this.courierName = courierName;
		this.remark = remark;
	}
	public double getMoney() {
		return money;
	}
	public String getCourierNum() {
		return courierNum;
	}
	public String getCourierName() {
		return courierName;
	}
	public String getRemark() {
		return remark;
	}
	
}
