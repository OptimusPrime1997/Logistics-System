package bl.logbl;

import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import PO.LogPO;
import VO.LogVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.logblservice.LogBLService;

public class LogController implements LogBLService{
	private Logbl logbl = new Logbl();

	public ResultMessage add(LogVO vo) {
		return logbl.add(vo);
		
	}

	public ArrayList<LogVO> show(String startTime, String endTime, LogType type) {
		return logbl.show(startTime, endTime, type);
	}
//
	public static void main(String[] args) {
		LogBLService ctr=ControllerFactoryImpl.getInstance().getLogController();
		ArrayList<LogVO> vos=ctr.show(CurrentTime.getDate(), CurrentTime.getDate(), LogType.ADD_A_GOODS);
	     System.out.println(vos.get(0).operatorID);
	}

}
