package PO;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<PO.ReceiptPO.PayRepPO> moneyOutRecord;
	private ArrayList<PO.ReceiptPO.CashPO> moneyInRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<PO.ReceiptPO.PayRepPO> moneyOutRecord,
			ArrayList<PO.ReceiptPO.CashPO> moneyInRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.moneyOutRecord = moneyOutRecord;
		this.moneyInRecord=moneyInRecord;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public ArrayList<PO.ReceiptPO.PayRepPO> getMoneyOutRecord() {
		return moneyOutRecord;
	}

	public ArrayList<PO.ReceiptPO.CashPO> getMoneyInRecord() {
		return moneyInRecord;
	}
	
	
	
}
