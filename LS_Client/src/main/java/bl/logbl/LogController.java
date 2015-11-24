package bl.logbl;

import java.util.ArrayList;

import VO.LogVO;
import blservice.logblservice.LogBLService;
import util.enumData.LogType;

public class LogController implements LogBLService{
	private Logbl logbl = new Logbl();

	public void add(LogVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
