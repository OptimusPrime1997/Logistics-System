package blservice.logblservice;

import java.util.ArrayList;

import bl.logbl.LogType;
import VO.LogVO;

public interface LogBLService {
	/**
	 * add log
	 * @param vo
	 */
	public void add(LogVO vo);
	/**
	 * return all the log of operations in that type,in that part of time
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @return
	 */
	public ArrayList<LogVO> show(String startTime,String endTime,LogType type);

}
