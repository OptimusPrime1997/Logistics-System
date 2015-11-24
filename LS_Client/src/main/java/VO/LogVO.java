package VO;

import java.util.ArrayList;

import util.enumData.LogType;
import PO.LogPO;
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
	public static LogPO toPO(LogVO vo){
		LogPO po=new LogPO(vo.operationName, vo.operatorID, vo.time);
		return po;
	}
	public static ArrayList<LogVO> toVOArray (ArrayList<LogPO> pos){
		ArrayList<LogVO> vos=new ArrayList<LogVO>();
		for(LogPO po:pos) vos.add(new LogVO(po));
		return vos;
	}
	
	public static ArrayList<LogPO> toPOArray (ArrayList<LogVO> vos){
		ArrayList<LogPO> pos=new ArrayList<LogPO>();
		for(LogVO vo:vos) pos.add(toPO(vo));
		return pos;
	}
	
	
	
}
