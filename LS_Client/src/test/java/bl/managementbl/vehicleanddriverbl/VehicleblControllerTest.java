package bl.managementbl.vehicleanddriverbl;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.AfterClass;
import org.junit.Test;

import util.enumData.ResultMessage;
import util.enumData.Sex;
import Exception.NumNotFoundException;
import VO.ManagementVO.VehicleVO;

public class VehicleblControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		VehicleblController vehicleblController = new VehicleblController();
		VehicleVO vo = null;
		VehicleVO vo1 = null;
		try {
			ResultMessage[] rmsgs = new ResultMessage[3];
			rmsgs[0] = vehicleblController.insertVehicle(new VehicleVO("025001007","苏A88887","20100101"));
			rmsgs[1] = vehicleblController.insertVehicle(new VehicleVO("025001008","苏A88898","20100101"));
			rmsgs[2] = vehicleblController.insertVehicle(new VehicleVO("025001009","苏A88889","20100101"));
			for (int i = 0; i < 3; i++) {
				System.out.println(rmsgs[i].toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = vehicleblController.findByVehicleNum("025001007");
			System.out.println(vo.licenseNum);
			assertEquals("苏A8887", vo.licenseNum);
			// vehiclebl.delete(vo);
			vo1 = vehicleblController.findByVehicleNum("025001008");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vo1 != null) {
			assertEquals("苏A8888", vo1.licenseNum);
		} else {
			System.out.println("vo is null");
		}

	}

}
