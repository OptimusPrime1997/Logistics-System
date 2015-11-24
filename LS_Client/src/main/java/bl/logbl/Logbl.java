package bl.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class Logbl {
	LogDataService logData=DataFactory.getLogdata();
	public void add(LogVO vo) {
		try {
			logData.add(LogVO.toPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		ArrayList<LogVO> logs=null;
		try {
			logs=LogVO.toVOArray(logData.show(type));
		} catch (RemoteException e) {
		}
		return logs;
	}

}
