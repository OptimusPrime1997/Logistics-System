package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<VO.PayRepVO> moneyOutRecord;
	private ArrayList<VO.CashRepVO> moneyInRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<VO.PayRepVO> moneyOutRecord,
			ArrayList<VO.CashRepVO> moneyInRecord) {
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

	public ArrayList<VO.PayRepVO> getMoneyOutRecord() {
		return moneyOutRecord;
	}

	public ArrayList<VO.CashRepVO> getMoneyInRecord() {
		return moneyInRecord;
	}
	
	
	
}
