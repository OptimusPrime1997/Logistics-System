package PO.ReceiptPO;

import java.io.Serializable;
import java.util.ArrayList;

public class PayRepRentRepPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4186423149724347074L;
	
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
