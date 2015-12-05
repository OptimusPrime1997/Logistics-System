package PO.ReceiptPO;

public class BonusPO extends AllSalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -882537465571433504L;
	
	private String remark;

	public BonusPO(String getterName, String getterNum, double money, String remark) {
		super(getterName, getterNum, money);
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	
}
