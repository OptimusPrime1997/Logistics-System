package bl.logbl;

import java.util.ArrayList;

import util.enumData.LogType;
import VO.LogVO;
import blservice.logblservice.LogBLService;

public class LogController implements LogBLService{
	private Logbl logbl = new Logbl();

	public void add(LogVO vo) {
		logbl.add(vo);
		
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		return logbl.show(startTime, endTime, type);
	}

	

}
