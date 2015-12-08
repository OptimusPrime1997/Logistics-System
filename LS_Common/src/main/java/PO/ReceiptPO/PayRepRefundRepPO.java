package PO.ReceiptPO;

import java.io.Serializable;
import java.util.ArrayList;

public class PayRepRefundRepPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2631001432702803073L;
	
	private double sum;
	private String date;
	private ArrayList<PayRefundPO> refundPOs;
	private String bankAccountNum;
	public PayRepRefundRepPO(double sum, String date, ArrayList<PayRefundPO> refundPOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.refundPOs = refundPOs;
		this.bankAccountNum = bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	public String getDate() {
		return date;
	}
	public ArrayList<PayRefundPO> getRefundPOs() {
		return refundPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	
}
