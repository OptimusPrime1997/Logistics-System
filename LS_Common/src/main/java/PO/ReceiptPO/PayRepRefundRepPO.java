package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepRefundRepPO {
	private double sum;
	private String date;
	private ArrayList<PayRefundPO> littleThingPOs;
	private String bankAccountNum;
	public PayRepRefundRepPO(double sum, String date, ArrayList<PayRefundPO> littleThingPOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.littleThingPOs = littleThingPOs;
		this.bankAccountNum = bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	public String getDate() {
		return date;
	}
	public ArrayList<PayRefundPO> getLittleThingPOs() {
		return littleThingPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	
}
