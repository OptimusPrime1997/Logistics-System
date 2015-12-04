package PO.ReceiptPO;

import java.util.ArrayList;

public class RentRepPO {
	private ArrayList<RentPO> rentPOs;
	private String bankAccountNum;
	private double sum;
	public RentRepPO(ArrayList<RentPO> rentPOs, String bankAccountNum, double sum) {
		super();
		this.rentPOs = rentPOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public ArrayList<RentPO> getRentPOs() {
		return rentPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	
}
