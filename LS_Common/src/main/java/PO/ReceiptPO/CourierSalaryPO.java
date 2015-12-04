package PO.ReceiptPO;

public class CourierSalaryPO extends AllSalaryPO{
	private int getMoneySum;
	private int deliverItemNum;
	public CourierSalaryPO(String getterName, String getterNum, double money, int getMoneySum, int deliverItemNum) {
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
