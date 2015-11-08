package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class BusinessFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startTime;
	private String endTime;
	private ArrayList<VO.PayRepVO> financialRecord;
	
	public BusinessFormPO(String startTime, String endTime,
			ArrayList<VO.PayRepVO> financialRecord) {
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

	public ArrayList<VO.PayRepVO> getFinancialRecord() {
		return financialRecord;
	}
	
	
}
