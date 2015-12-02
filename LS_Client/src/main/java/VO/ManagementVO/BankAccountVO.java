package VO.ManagementVO;

public class BankAccountVO {
	public String bankAccountNum;
	public String bankAccountName;
	public double balance;

	public BankAccountVO(String bankAccountNum, String bankAccountName,
			double balance) {
		// TODO Auto-generated constructor stub
		this.bankAccountNum = bankAccountNum;
		this.bankAccountName = bankAccountName;
		this.balance = balance;
	}
}
