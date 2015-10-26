package PO;

import java.io.Serializable;

public class LogPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String operationName;
	private String operatorID;
	private String time;
	
	public LogPO(String operationName, String operatorID, String time) {
		this.operationName = operationName;
		this.operatorID = operatorID;
		this.time = time;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
