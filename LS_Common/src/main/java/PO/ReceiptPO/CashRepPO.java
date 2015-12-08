package PO.ReceiptPO;

import java.util.ArrayList;

public class CashRepPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7719250032350218076L;
	
	private ArrayList<CashPO> cashPOs;
	private double sum;
	private String bankAccount;
	
	public CashRepPO(String num, String date, ArrayList<CashPO> cashPOs, double sum, String bankAccount) {
		super(num, date);
		this.cashPOs = cashPOs;
		this.sum = sum;
		this.bankAccount = bankAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<CashPO> getCashPOs() {
		return cashPOs;
	}

	public double getSum() {
		return sum;
	}

	public String getBankAccount() {
		return bankAccount;
	}
	
}
