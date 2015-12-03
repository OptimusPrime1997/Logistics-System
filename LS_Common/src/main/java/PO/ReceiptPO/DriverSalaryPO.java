package PO.ReceiptPO;

public class DriverSalaryPO extends AllSalaryPO{
	private int time;
	public DriverSalaryPO(String getterName, String getterNum, double money, int time){
		super(getterName, getterNum, money);
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
}
