package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepFreightRepPO {
	private double sum;
	private String bankAccountNum;
	private ArrayList<PayFreightPO> transferPayPOs;
	public PayRepFreightRepPO(double sum, String bankAccountNum, ArrayList<PayFreightPO> transferPayPOs) {
		super();
		this.sum = sum;
		this.bankAccountNum = bankAccountNum;
		this.transferPayPOs = transferPayPOs;
	}
	public double getSum() {
		return sum;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public ArrayList<PayFreightPO> getTransferPayPOs() {
		return transferPayPOs;
	}
	
}
