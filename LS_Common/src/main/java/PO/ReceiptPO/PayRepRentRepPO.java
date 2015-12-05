package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepRentRepPO {
	private ArrayList<PayRentPO> rentPOs;
	private String bankAccountNum;
	private double sum;
	public PayRepRentRepPO(ArrayList<PayRentPO> rentPOs, String bankAccountNum, double sum) {
		super();
		this.rentPOs = rentPOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public ArrayList<PayRentPO> getRentPOs() {
		return rentPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	
}
