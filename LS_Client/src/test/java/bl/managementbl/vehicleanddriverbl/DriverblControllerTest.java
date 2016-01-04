//package bl.managementbl.vehicleanddriverbl;
//
//import static org.junit.Assert.*;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.junit.AfterClass;
//import org.junit.Test;
//
//import util.enumData.ResultMessage;
//import util.enumData.Sex;
//import Exception.NumNotFoundException;
//import VO.ManagementVO.DriverVO;
//
//public class DriverblControllerTest {
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		ResultMessage rmsg = null;
//		ArrayList<ResultMessage> rmsgs=new ArrayList<ResultMessage>();
//		DriverblController driverblController = new DriverblController();
//		DriverVO vo = null;
//		DriverVO vo1 = null;
//		DriverVO test=null;
//		try {
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02500107001", "王一", Sex.Sex_MALE, "550550199101010001",
//					"18200010001", "20160101",0));
//				rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02500207001", "王二", Sex.Sex_MALE, "550550199101010002",
//					"18200020002", "20170101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02500307001", "王三", Sex.Sex_FAMALE, "550550199101010003",
//					"18200030003", "20180101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02500107004", "王四", Sex.Sex_MALE, "550550199101010004",
//					"18200040004", "20190101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02500207005", "王五", Sex.Sex_MALE, "550550199101010005",
//					"18200050005", "20200101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(test=new DriverVO(
//					"02500307006", "王六", Sex.Sex_FAMALE, "550550199101010006",
//					"18200060006", "20210101",0));
//			rmsgs.add(rmsg);
//			
//			
//			
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02100107001", "刘一", Sex.Sex_MALE, "550550199101010211",
//					"18202110211", "20160101",0));
//				rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02100207001", "刘二", Sex.Sex_MALE, "550550199101010212",
//					"18202120212", "20170101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02100307001", "刘三", Sex.Sex_FAMALE, "550550199101010213",
//					"18202130213", "20180101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02100107004", "刘四", Sex.Sex_MALE, "550550199101010214",
//					"18202140214", "20190101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02100207005", "刘五", Sex.Sex_MALE, "550550199101010215",
//					"18202150215", "20200101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(test=new DriverVO(
//					"02100307006", "刘六", Sex.Sex_FAMALE, "550550199101010216",
//					"18202160216", "20210101",0));
//			rmsgs.add(rmsg);
//			
//			
//			
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02020107001", "武一", Sex.Sex_MALE, "550550199101010201",
//					"18202010201", "20160101",0));
//				rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02020207001", "武二", Sex.Sex_MALE, "550550199101010202",
//					"18202020202", "20170101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02020307001", "武三", Sex.Sex_FAMALE, "550550199101010203",
//					"18202030203", "20180101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02020107004", "武四", Sex.Sex_MALE, "550550199101010204",
//					"18202040204", "20190101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"02020207005", "武五", Sex.Sex_MALE, "550550199101010205",
//					"18202050205", "20200101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(test=new DriverVO(
//					"02020307006", "武六", Sex.Sex_FAMALE, "550550199101010206",
//					"18202060206", "20210101",0));
//			rmsgs.add(rmsg);
//			
//			
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"01000107001", "李一", Sex.Sex_MALE, "550550199101010101",
//					"18201010101", "20160101",0));
//				rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"01000207001", "李二", Sex.Sex_MALE, "550550199101010102",
//					"18201020102", "20170101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"01000307001", "李三", Sex.Sex_FAMALE, "550550199101010103",
//					"18201030103", "20180101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"01000107004", "李四", Sex.Sex_MALE, "550550199101010104",
//					"18201040104", "20190101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(new DriverVO(
//					"01000207005", "李五", Sex.Sex_MALE, "550550199101010105",
//					"18201050105", "20200101",0));
//			rmsgs.add(rmsg);
//			rmsg = driverblController.insertDriver(test=new DriverVO(
//					"01000307006", "李六", Sex.Sex_FAMALE, "550550199101010106",
//					"18201060106", "20210101",0));
//			rmsgs.add(rmsg);
//			
//			for (int i = 1; i <rmsgs.size() ; i++) {
//				System.out.println(ResultMessage.toFriendlyString(rmsgs.get(i)));
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
////		try {
////			vo = driverblController.findByDriverNum("02500107001");
////			System.out.println(vo.name);
////			assertEquals("王一", vo.name);
////			// driverbl.delete(vo);
////			vo1 = driverblController.findByDriverNum("02500107002");
////		} catch (RemoteException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (ClassNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (NumNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		if (vo1 != null) {
////			assertEquals("550550199101010002", vo1.id);
////		} else {
////			System.out.println("vo1 is null");
////		}
//
//	}
//
//}
