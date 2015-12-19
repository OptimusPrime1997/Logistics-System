package bl.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
import dataservice.logdataservice.LogDataService;

public class MockLogData implements LogDataService {

	@Override
	public ArrayList<LogPO> show(LogType type, String startTime, String endTime)
			throws RemoteException {
		ArrayList<LogPO> pos=new ArrayList<LogPO>();
		for(int i=1;i<6;i++){
			LogPO po=new LogPO(LogType.ADD_A_GOODS, "0250000611"+i, "2015-12-0"+i);
			pos.add(po);
		}
		return pos;
	}

	@Override
	public ResultMessage add(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
