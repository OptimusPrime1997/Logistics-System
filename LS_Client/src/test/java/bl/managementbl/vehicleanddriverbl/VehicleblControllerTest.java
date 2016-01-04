//package bl.managementbl.vehicleanddriverbl;
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
//import VO.ManagementVO.VehicleVO;
//
//public class VehicleblControllerTest {
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		VehicleblController vehicleblController = new VehicleblController();
//		VehicleVO vo = null;
//		VehicleVO vo1 = null;
//		try {
//			ArrayList<ResultMessage> rmsgs=new ArrayList<ResultMessage>();
//			ResultMessage rmsg =null;
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025001001","苏A11111","20110101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025001002","苏A11112","20120101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025002001","苏A11113","20130101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025002002","苏A11114","20140101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025003001","苏A11115","20150101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("025003002","苏A11115","20150102"));
//			rmsgs.add(rmsg);
//
//			
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021001001","沪A10211","20110101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021001002","沪A10212","20120101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021002001","沪A10213","20130101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021002002","沪A10214","20140101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021003001","沪A10215","20150101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("021003002","沪A10215","20150102"));
//			rmsgs.add(rmsg);
//			
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020001001","广A10201","20110101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020001002","广A10202","20120101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020002001","广A10203","20130101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020002002","广A10204","20140101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020003001","广A10205","20150101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("020003002","广A10205","20150102"));
//			rmsgs.add(rmsg);
//			
//			
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010001001","京A10101","20110101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010001002","京A10102","20120101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010002001","京A10103","20130101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010002002","京A10104","20140101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010003001","京A10105","20150101"));
//			rmsgs.add(rmsg);
//			rmsg = vehicleblController.insertVehicle(new VehicleVO("010003002","京A10105","20150102"));
//			rmsgs.add(rmsg);
//			for (int i = 0; i < rmsgs.size(); i++) {
//				System.out.println(ResultMessage.toFriendlyString(rmsgs.get(i)));
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		}
////		try {
////			vo = vehicleblController.findByVehicleNum("025001002");
////			System.out.println(vo.licenseNum);
////			assertEquals("苏A22222", vo.licenseNum);
////			// vehiclebl.delete(vo);
////			vo1 = vehicleblController.findByVehicleNum("025001001");
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
////			assertEquals("苏A11111", vo1.licenseNum);
////		} else {
////			System.out.println("vo is null");
////		}
////
//	}
//
//}
