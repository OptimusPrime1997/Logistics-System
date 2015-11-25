package PO;

import java.io.Serializable;

public class AllSalaryPO implements Serializable{
	private String getterName;
	private String getterNum;
	private double money;
	public AllSalaryPO(String getterName, String getterNum, double money) {
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
