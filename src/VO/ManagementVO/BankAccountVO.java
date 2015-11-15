package VO.ManagementVO;

public class BankAccountVO {
	private String bankAccountNum;
	private String bankAccountName;
	private int balance;

	public BankAccountVO(String bankAccountNum, String bankAccountName,
			int balance) {
		// TODO Auto-generated constructor stub
		this.bankAccountNum = bankAccountNum;
		this.bankAccountName = bankAccountName;
		this.balance = balance;
	}
}
