package VO;

import java.util.ArrayList;


public class BusinessFormVO {
	public String startTime;
	public String endTime;
	public ArrayList<PayRepVO> financialRecord;
	
	public BusinessFormVO(String startTime, String endTime,
			ArrayList<PayRepVO> financialRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.financialRecord = financialRecord;
	}
}
