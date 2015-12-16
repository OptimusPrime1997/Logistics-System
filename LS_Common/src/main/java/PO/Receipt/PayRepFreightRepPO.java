package PO.Receipt;

import java.io.Serializable;
import java.util.ArrayList;

public class PayRepFreightRepPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6480927576134025429L;
	
	private double sum;
	private String bankAccountNum;
	private ArrayList<PayFreightPO> payFreightPOs;
	public PayRepFreightRepPO(double sum, String bankAccountNum, ArrayList<PayFreightPO> payFreightPOs) {
		super();
		this.sum = sum;
		this.bankAccountNum = bankAccountNum;
		this.payFreightPOs = payFreightPOs;
	}
	public double getSum() {
		return sum;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public ArrayList<PayFreightPO> getPayFreightPOs() {
		return payFreightPOs;
	}
	
}
