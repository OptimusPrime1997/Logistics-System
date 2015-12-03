package VO.ReceiptVO;

public class AllSalaryVO {
	public String getterName;
	public String getterNum;
	public double money;
	
	public AllSalaryVO(String getterName, String getterNum, double money) {
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.money = money;
	}
	
	public AllSalaryVO(){
		
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