package PO;

public class CourierSalaryPO extends AllSalaryPO{
	private int getMoney;
	private int deliverItemNum;
	
	public CourierSalaryPO(String getterName, String getterNum, double money, int getMoney, int deliverItemNum){
		super(getterName, getterNum, getMoney);
		this.getMoney = getMoney;
		this.deliverItemNum = deliverItemNum;
	}

	public int getGetMoney() {
		return getMoney;
	}

	public int getDeliverItemNum() {
		return deliverItemNum;
	}
	
}
