package PO;

import java.io.Serializable;

import util.enumData.LogType;

public class LogPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private LogType operationName;
	private String operatorID;
	private String time;
	
	public LogPO(LogType operationName, String operatorID, String time) {
		this.operationName = operationName;
		this.operatorID = operatorID;
		this.time = time;
	}
	public LogType getOperationName() {
		return operationName;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public String getTime() {
		return time;
	}
	
}
