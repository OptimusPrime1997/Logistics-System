package VO;

public class LogVO {
	public String operationName;
	public String operatorID;
	public String time;
	
	public LogVO(String operationName, String operatorID, String time) {
		this.operationName = operationName;
		this.operatorID = operatorID;
		this.time = time;
	}
}
