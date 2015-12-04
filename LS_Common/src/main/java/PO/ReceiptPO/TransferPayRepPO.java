package PO.ReceiptPO;

import java.util.ArrayList;

public class TransferPayRepPO {
	private double sum;
	private String bankAccountNum;
	private ArrayList<TransferPayPO> transferPayPOs;
	public TransferPayRepPO(double sum, String bankAccountNum, ArrayList<TransferPayPO> transferPayPOs) {
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
	public ArrayList<TransferPayPO> getTransferPayPOs() {
		return transferPayPOs;
	}
	
}
