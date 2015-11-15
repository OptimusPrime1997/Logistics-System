package bl.logbl;

import java.util.ArrayList;

import VO.LogVO;
import blservice.logblservice.LogBLService;

public class LogController implements LogBLService{
	private Logbl logbl = new Logbl();
	@Override
	public void add(LogVO vo) {
		logbl.add(vo);
	}

	@Override
	public ArrayList<LogVO> show(String startTime, String endTime, String type) {
		return logbl.show(startTime, endTime, type);
	}

}
