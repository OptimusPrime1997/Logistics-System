package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepSalaryRepPO {
	private ArrayList<PaySalaryPO> allSalaryPOs;
	private String bankAccountNum;
	private double sum;
	public PayRepSalaryRepPO(ArrayList<PaySalaryPO> allSalaryPOs, String bankAccountNum, double sum) {
		super();
		this.allSalaryPOs = allSalaryPOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public ArrayList<PaySalaryPO> getAllSalaryPOs() {
		return allSalaryPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	
}
