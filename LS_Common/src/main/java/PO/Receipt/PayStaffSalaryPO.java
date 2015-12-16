package PO.Receipt;

import util.enumData.Authority;

public class PayStaffSalaryPO extends PaySalaryPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2857552232803376700L;
	
	private Authority authority;
	public PayStaffSalaryPO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}
	public Authority getAuthority() {
		return authority;
	}
	
}