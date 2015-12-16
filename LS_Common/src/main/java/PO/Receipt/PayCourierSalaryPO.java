package PO.Receipt;

public class PayCourierSalaryPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5246247747908523375L;
	
	private int getMoneySum;
	private int deliverItemNum;
	public PayCourierSalaryPO(String getterName, String getterNum, double money, int getMoneySum, int deliverItemNum) {
		super(getterName, getterNum, money);
		this.getMoneySum = getMoneySum;
		this.deliverItemNum = deliverItemNum;
	}
	public int getGetMoneySum() {
		return getMoneySum;
	}
	public int getDeliverItemNum() {
		return deliverItemNum;
	}
	
}
