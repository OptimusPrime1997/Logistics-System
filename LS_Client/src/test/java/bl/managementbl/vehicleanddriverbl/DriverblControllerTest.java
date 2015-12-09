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
import VO.ManagementVO.DriverVO;

public class DriverblControllerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		String[] autoNum = new String[3];
		DriverblController driverblController = new DriverblController();
		DriverVO vo = null;
		DriverVO vo1 = null;
		try {
			autoNum[0] = driverblController.insertDriver(new DriverVO(
					"02500107002", "张五", Sex.Sex_MALE, "511302199903045342",
					"18290392453", "20180101"));
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"02500107003", "祝四", Sex.Sex_MALE, "511302199903054535",
					"18290392454", "20180101"));
			autoNum[2] = driverblController.insertDriver(new DriverVO(
					"02500107004", "周泰", Sex.Sex_MALE, "511302199903064536",
					"18290392455", "20180101"));
			for (int i = 0; i < 3; i++) {
				System.out.println(autoNum[i].toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = driverblController.findByDriverNum(autoNum[0]);
			System.out.println(vo.name);
			assertEquals("张五", vo.name);
			// driverbl.delete(vo);
			vo1 = driverblController.findByDriverNum(autoNum[1]);
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
			assertEquals("511302199903054535", vo1.id);
		} else {
			System.out.println("vo is null");
		}

	}

}
