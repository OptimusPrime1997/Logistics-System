package PO.ReceiptPO;

import java.util.ArrayList;

public class AllSalaryRepPO {
	private ArrayList<AllSalaryPO> allSalaryPOs;
	private String bankAccountNum;
	private double sum;
	public AllSalaryRepPO(ArrayList<AllSalaryPO> allSalaryPOs, String bankAccountNum, double sum) {
		super();
		this.allSalaryPOs = allSalaryPOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public ArrayList<AllSalaryPO> getAllSalaryPOs() {
		return allSalaryPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	
}
