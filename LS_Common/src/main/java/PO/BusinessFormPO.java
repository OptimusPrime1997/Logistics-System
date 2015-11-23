package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<PO.PayRepPO> moneyOutRecord;
	private ArrayList<PO.CashRepPO> moneyInRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<PO.PayRepPO> moneyOutRecord,
			ArrayList<PO.CashRepPO> moneyInRecord) {
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

	public ArrayList<PO.PayRepPO> getMoneyOutRecord() {
		return moneyOutRecord;
	}

	public ArrayList<PO.CashRepPO> getMoneyInRecord() {
		return moneyInRecord;
	}
	
	
	
}
