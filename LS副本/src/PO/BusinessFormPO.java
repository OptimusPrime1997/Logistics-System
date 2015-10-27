package PO;

import java.io.Serializable;
import java.util.ArrayList;

import VO.ReceiptVO.PayRepVO;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<PayRepVO> financialRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<PayRepVO> financialRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.financialRecord = financialRecord;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public ArrayList<PayRepVO> getFinancialRecord() {
		return financialRecord;
	}
	
	
}
