package PO;

public class RentPO {
	private String getterName;
	private String phoneNum;
	private double money;
	private String date;
	
	public RentPO(String getterName, String phoneNum, double money, String date) {
		super();
		this.getterName = getterName;
		this.phoneNum = phoneNum;
		this.money = money;
		this.date = date;
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

	public String getDate() {
		return date;
	}
	
}