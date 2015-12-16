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
			ResultMessage[] rmsgs = new ResultMessage[5];
			rmsgs[0] = vehicleblController.insertVehicle(new VehicleVO("025001001","苏A11111","20110101"));
			rmsgs[1] = vehicleblController.insertVehicle(new VehicleVO("025001002","苏A22222","20120101"));
			rmsgs[2] = vehicleblController.insertVehicle(new VehicleVO("025001003","苏A33333","20130101"));
			rmsgs[3] = vehicleblController.insertVehicle(new VehicleVO("025001004","苏A44444","20140101"));
			rmsgs[4] = vehicleblController.insertVehicle(new VehicleVO("025001005","苏A55555","20150101"));
			
			for (int i = 0; i < 3; i++) {
				System.out.println(rmsgs[i].toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = vehicleblController.findByVehicleNum("025001002");
			System.out.println(vo.licenseNum);
			assertEquals("苏A22222", vo.licenseNum);
			// vehiclebl.delete(vo);
			vo1 = vehicleblController.findByVehicleNum("025001001");
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
			assertEquals("苏A11111", vo1.licenseNum);
		} else {
			System.out.println("vo is null");
		}

	}

}
