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
		ResultMessage[] autoNum = new ResultMessage[3];
		DriverblController driverblController = new DriverblController();
		DriverVO vo = null;
		DriverVO vo1 = null;
		DriverVO test=null;
		try {
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"02500107001", "王一", Sex.Sex_MALE, "550550199101010001",
					"18200010001", "20160101",0));
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"02500107002", "王二", Sex.Sex_MALE, "550550199101010002",
					"18200020002", "20170101",0));
			autoNum[2] = driverblController.insertDriver(new DriverVO(
					"02500107003", "王三", Sex.Sex_FAMALE, "550550199101010003",
					"18200030003", "20180101",0));
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"02500107004", "王四", Sex.Sex_MALE, "550550199101010004",
					"18200040004", "20190101",0));
			autoNum[1] = driverblController.insertDriver(new DriverVO(
					"02500107005", "王五", Sex.Sex_MALE, "550550199101010005",
					"18200050005", "20200101",0));
			autoNum[2] = driverblController.insertDriver(test=new DriverVO(
					"02500107006", "王六", Sex.Sex_FAMALE, "550550199101010006",
					"18200060006", "20210101",0));
			ResultMessage r=driverblController.deleteDriver(test);
			System.out.println("删除driver:    "+r);
			for (int i = 1; i < 3; i++) {
				System.out.println(autoNum[i]);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			vo = driverblController.findByDriverNum("02500107001");
			System.out.println(vo.name);
			assertEquals("王一", vo.name);
			// driverbl.delete(vo);
			vo1 = driverblController.findByDriverNum("02500107002");
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
			assertEquals("550550199101010002", vo1.id);
		} else {
			System.out.println("vo1 is null");
		}

	}

}
