package PO.ReceiptPO;

public class PayDriverSalaryPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8884966303813471647L;
	
	private int time;
	public PayDriverSalaryPO(String getterName, String getterNum, double money, int time){
		super(getterName, getterNum, money);
		this.time = time;
	}
	public int getTime() {
		return time;
	}
	
}
