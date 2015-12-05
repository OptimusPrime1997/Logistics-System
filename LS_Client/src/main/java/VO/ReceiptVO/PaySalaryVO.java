package VO.ReceiptVO;

public class PaySalaryVO {
	public String getterName;
	public String getterNum;
	public double money;
	
	public PaySalaryVO(String getterName, String getterNum, double money) {
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.money = money;
	}
	
	public PaySalaryVO(){
		
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