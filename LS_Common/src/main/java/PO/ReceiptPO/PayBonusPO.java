package PO.ReceiptPO;

public class PayBonusPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -882537465571433504L;
	
	private String remark;

	public PayBonusPO(String getterName, String getterNum, double money, String remark) {
		super(getterName, getterNum, money);
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	
}
