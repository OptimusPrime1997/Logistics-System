package bl.managementbl.vehicleanddriverbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.AfterClass;
import org.junit.Test;

import util.enumData.ResultMessage;
import util.enumData.Sex;
import Exception.AutoNumException;
import Exception.ExistException;
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
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"12511119112", "张五", Sex.Sex_MALE, "911312166613145342",
					"19261362453", "21191111"));
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"12511119113", "祝四", Sex.Sex_MALE, "911312166613154535",
					"19261362454", "21191111"));
			autoNum[2] = driverblController.insertDriver(new DriverVO(
					"12511119114", "周泰", Sex.Sex_MALE, "911312166613164536",
					"19261362455", "21191111"));
			for (int i = 1; i < 3; i++) {
				System.out.println(autoNum[i]);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AutoNumException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("该人员已存在");
		}
		try {
			vo = driverblController.findByDriverNum("12511119112");
			System.out.println(vo.name);
			assertEquals("张五", vo.name);
			// driverbl.delete(vo);
//			vo1 = driverblController.findByDriverNum(autoNum[1]);
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
			assertEquals("911312166613154535", vo1.id);
		} else {
			System.out.println("vo is null");
		}

	}

}
