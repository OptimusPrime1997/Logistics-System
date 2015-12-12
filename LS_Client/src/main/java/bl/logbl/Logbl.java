package bl.logbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class Logbl {
	public ResultMessage add(LogVO vo) {
//		try {
//			return getLogDataService().add(LogVO.toPO(vo));
//		} catch (RemoteException e) {
//			return ResultMessage.LINK_FAILURE;
//		}
		//TODO
		return ResultMessage.SUCCESS;
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		MockLogData data=new MockLogData();
		ArrayList<LogVO> logs = null;
		try {
//			logs = LogVO.toVOArray(getLogDataService().show(type, startTime, endTime));
			logs=LogVO.toVOArray(data.show(type, startTime, endTime));
		} catch (RemoteException e) {
		}
		return logs;
	}
	private LogDataService getLogDataService() {
		LogDataService dataservice = null;
		try {
			dataservice = (LogDataService)Naming.lookup("log");
			
		} catch (Exception e) {
			e.printStackTrace();
		}return dataservice;
	}
}
