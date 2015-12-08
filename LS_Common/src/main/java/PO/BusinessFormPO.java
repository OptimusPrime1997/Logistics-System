package PO;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.PayRepPO;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<ArrayList<PayRepPO>> moneyOutRecord;
	private ArrayList<ArrayList<CashRepPO>> moneyInRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<ArrayList<PayRepPO>> moneyOutRecord,
			ArrayList<ArrayList<CashRepPO>> moneyInRecord) {
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

	public ArrayList<ArrayList<PayRepPO>> getMoneyOutRecord() {
		return moneyOutRecord;
	}

	public ArrayList<ArrayList<CashRepPO>> getMoneyInRecord() {
		return moneyInRecord;
	}

	
	
	
	
}
