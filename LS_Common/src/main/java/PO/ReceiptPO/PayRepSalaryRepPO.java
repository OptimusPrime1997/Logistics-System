package PO.ReceiptPO;

import java.io.Serializable;
import java.util.ArrayList;

public class PayRepSalaryRepPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8351843289589490595L;
	
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
