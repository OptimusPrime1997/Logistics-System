package bl.logbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.logblservice.LogBLService;

public class LogControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

//	@Test
//	public void test() {
//		LogController logController = new LogController();
//
//		LogBLService ctr = ControllerFactoryImpl.getInstance()
//				.getLogController();
//		ArrayList<LogVO> vos = ctr.show(CurrentTime.getDate(),
//				CurrentTime.getDate(), LogType.ADD_A_GOODS);
//		System.out.println(vos.get(0).operatorID);
//	}
	@Test
	public void test() {
		LogBLService logController = ControllerFactoryImpl.getInstance()
				.getLogController();
		ResultMessage r=logController.add(new LogVO(LogType.ADD_A_GOODS,"02500101001","2015-12-18"));
		if(r==ResultMessage.SUCCESS){
			System.out.println("日志提交成功");
			ArrayList<LogVO> logVOs = logController.show("2015-11-01",
					"2015-12-31", LogType.ALL);
			if (logVOs != null) {
				System.out.println(logVOs.size());
			} else {
				System.out.println(logVOs.get(0).time);
			}
		}else{
			System.out.println("日志提交失败");
		}
	}


}
