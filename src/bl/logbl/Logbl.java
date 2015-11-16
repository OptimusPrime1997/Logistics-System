package bl.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.DataFactory;
import VO.LogVO;
import dataservice.logdataservice.LogDataService;

public class Logbl {
	LogDataService logData=DataFactory.getLogdata();
	public void add(LogVO vo) {
		try {
			logData.add(vo.toPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<LogVO> show(String startTime, String endTime, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
