package PO.ReceiptPO;

public class DriverSalaryPO extends AllSalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8884966303813471647L;
	
	private int time;
	public DriverSalaryPO(String getterName, String getterNum, double money, int time){
		super(getterName, getterNum, money);
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
}
