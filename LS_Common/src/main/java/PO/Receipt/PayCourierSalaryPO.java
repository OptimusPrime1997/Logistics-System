package PO.Receipt;

public class PayCourierSalaryPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5246247747908523375L;
	
	private double workMoney;
	
	public PayCourierSalaryPO(String getterName, String getterNum, double money, double workMoney) {
		super(getterName, getterNum, money);
		this.workMoney = workMoney;
	}
	public double getWorkMoney() {
		return workMoney;
	}
	
}
