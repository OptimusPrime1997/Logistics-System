package PO;

import java.io.Serializable;

public class BankAccountPO implements Serializable,Comparable<BankAccountPO>{
	public final static long serialVersionUID=1L;
	private String bankAccountNum;
	private String bankAccountName;
	private double balance;
	public BankAccountPO(String bankAccountNum,String bankAccountName,int balance) {
		// TODO Auto-generated constructor stub
		this.bankAccountNum=bankAccountNum;
		this.bankAccountName=bankAccountName;
		this.balance=balance;
	}

	public String getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int compareTo(BankAccountPO o) {
		// TODO Auto-generated method stub
		return bankAccountNum.compareTo(o.getBankAccountNum());
	}
}
