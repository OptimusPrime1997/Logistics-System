package PO.Receipt;

public class PayCourierSalaryPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5246247747908523375L;
	
	private double getMoneySum;
	private double deliverMoneySum;
	
	public PayCourierSalaryPO(String getterName, String getterNum, double money, double getMoneySum,
			double deliverMoneySum) {
		super(getterName, getterNum, money);
		this.getMoneySum = getMoneySum;
		this.deliverMoneySum = deliverMoneySum;
	}
	public double getGetMoneySum() {
		return getMoneySum;
	}
	public double getDeliverMoneySum() {
		return deliverMoneySum;
	}
	
}
