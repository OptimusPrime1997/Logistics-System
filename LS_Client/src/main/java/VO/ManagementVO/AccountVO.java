package VO.ManagementVO;

import PO.AccountPO;
import util.enumData.*;

public class AccountVO implements Comparable<AccountVO> {
	public String accountNum;
	public String accountName;
	public String password;
	public Sex sex;
	public Authority authority;
	public String phoneNum;
	public String institutionNum;

	public AccountVO(String accountNum, String accountName, String password,
			Sex sex, Authority authority, String phoneNum, String institution) {
		// TODO Auto-generated constructor stub
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.password = password;
		this.sex = sex;
		this.authority = authority;
		this.phoneNum = phoneNum;
		this.institutionNum = institution;
	}

	public int compareTo(AccountVO v) {
		// TODO Auto-generated method stub
		return accountNum.compareTo(v.accountNum);
	}

	public String toString() {
		return accountNum + "," + accountName + "," + password + ","
				+ sex.toString() + "," + authority.toString() + "," + phoneNum
				+ "," + institutionNum;
	}
}