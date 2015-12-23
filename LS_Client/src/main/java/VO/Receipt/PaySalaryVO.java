package VO.Receipt;

public class PaySalaryVO {
	public String getterName;
	public String getterNum;
	public double money;

	public PaySalaryVO(String getterName, String getterNum, double money) {
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.money = money;
	}

	public PaySalaryVO() {
	}
}