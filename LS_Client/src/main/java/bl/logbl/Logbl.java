package bl.logbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class Logbl {
	public static void main(String[] args) {
		Logbl ctr=new Logbl();
		ctr.add(new LogVO(LogType.ADD_A_GOODS, "02500106066", "2015-12-17"));
		ArrayList<LogVO> vos=ctr.show("2015-10-10", "2015-12-20", LogType.ALL);
		for(LogVO vo:vos){
			System.out.println(vo.operatorID+"  "+vo.time+"  "+vo.operationName);
		}
	}
	public ResultMessage add(LogVO vo) {
		 try {
			return getLogDataService().add(LogVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		ArrayList<LogVO> logs = null;
		try {
			logs = LogVO.toVOArray(getLogDataService().show(type, startTime, endTime));
		} catch (RemoteException e) {
		}
		return logs;
	}

	private LogDataService getLogDataService() {
		LogDataService dataservice = null;
		try {
			dataservice = (LogDataService) Naming.lookup("log");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataservice;
	}
}
