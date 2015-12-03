package PO.ReceiptPO;

import java.util.ArrayList;

public class AllSalaryRepPO {
	private ArrayList<AllSalaryPO> allSalaryPOs;
	private String BankAccountNum;
	public AllSalaryRepPO(ArrayList<AllSalaryPO> allSalaryPOs, String bankAccountNum) {
		super();
		this.allSalaryPOs = allSalaryPOs;
		BankAccountNum = bankAccountNum;
	}
	public ArrayList<AllSalaryPO> getAllSalaryPOs() {
		return allSalaryPOs;
	}
	public String getBankAccountNum() {
		return BankAccountNum;
	}
	
}
