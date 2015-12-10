package bl.logbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import util.CurrentTime;
import util.enumData.LogType;
import VO.LogVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.logblservice.LogBLService;

public class LogControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		LogController logController = new LogController();

		LogBLService ctr = ControllerFactoryImpl.getInstance()
				.getLogController();
		ArrayList<LogVO> vos = ctr.show(CurrentTime.getDate(),
				CurrentTime.getDate(), LogType.ADD_A_GOODS);
		System.out.println(vos.get(0).operatorID);
	}

}
