package VO;

import util.enumData.LogType;
import PO.LogPO;
<<<<<<< HEAD
import util.enumData.LogType;
=======
<<<<<<< HEAD
import util.enumData.LogType;
=======
>>>>>>> origin/master
>>>>>>> origin/master

public class LogVO {
	public LogType operationName;
	public String operatorID;
	public String time;
	
	public LogVO(LogType operationName, String operatorID, String time) {
		this.operationName = operationName;
		this.operatorID = operatorID;
		this.time = time;
	}
	public LogVO (LogPO po){
		this.operationName=po.getOperationName();
		this.operatorID=po.getOperatorID();
		this.time=po.getTime();
	}
	public LogPO toPO(LogVO vo){
		LogPO po=new LogPO(operationName, operatorID, time);
		return po;
	}
	
	
}
