package PO.ReceiptPO;

import util.enumData.Authority;

public class PayStaffSalaryPO extends PaySalaryPO{
	private Authority authority;
	public PayStaffSalaryPO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}
	public Authority getAuthority() {
		return authority;
	}
	
}