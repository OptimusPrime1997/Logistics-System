package PO;

public class BonusPO {
	private String getterName;
	private String getterNum;
	private double money;
	public BonusPO(String getterName, String getterNum, double money) {
		super();
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
