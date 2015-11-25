package PO;

import util.enumData.Authority;

public class SalaryPO extends AllSalaryPO{
	private Authority authority;
	public SalaryPO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}
	public Authority getAuthority() {
		return authority;
	}
	
}