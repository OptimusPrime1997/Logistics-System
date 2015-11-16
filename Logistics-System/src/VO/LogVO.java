package VO;

import PO.LogPO;

public class LogVO {
	public String operationName;
	public String operatorID;
	public String time;
	
	public LogVO(String operationName, String operatorID, String time) {
		this.operationName = operationName;
		this.operatorID = operatorID;
		this.time = time;
	}
	public LogPO toPO(LogVO vo){
		LogPO po=new LogPO(operationName, operatorID, time);
		return po;
	}
}
