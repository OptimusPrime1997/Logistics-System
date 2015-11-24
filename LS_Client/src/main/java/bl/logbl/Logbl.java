package bl.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import RMIClient.LogClient;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class Logbl {
	LogClient client=new LogClient();
	public LogDataService getLogDataService(){
		LogDataService dataservice=null;
		try {
		dataservice=client.getLogDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return dataservice;
	}
	public void add(LogVO vo) {
		try {
			getLogDataService().add(LogVO.toPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		ArrayList<LogVO> logs=null;
		try {
			logs=LogVO.toVOArray(getLogDataService().show(type));
		} catch (RemoteException e) {
		}
		return logs;
	}

}
