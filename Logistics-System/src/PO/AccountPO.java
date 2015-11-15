package PO;

import java.io.Serializable;
import util.enumData.*;

public class AccountPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String accountNum;
	private String accountName;
	private String password;
	private Sex sex;
	private Authority authority;
	private String phoneNum;
	private String institution;

	public AccountPO(String accountNum, String accountName, String password,
			Sex sex, Authority authority, String phoneNum, String institution) {

		// TODO Auto-generated constructor stub
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.password = password;
		this.sex = sex;
		this.authority = authority;
		this.phoneNum = phoneNum;
		this.institution = institution;

	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccoutName() {
		return accountName;
	}

	public void setAccoutName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
