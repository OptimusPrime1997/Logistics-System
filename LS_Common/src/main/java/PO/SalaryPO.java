package PO;

public class SalaryPO {
	private String getterName;
	private String getterNum;
	private String date;
	private double money;
	
	public SalaryPO(String getterName, String getterNum, String date, double money) {
		super();
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.date = date;
		this.money = money;
	}

	public String getGetterName() {
		return getterName;
	}

	public String getGetterNum() {
		return getterNum;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}
	
}