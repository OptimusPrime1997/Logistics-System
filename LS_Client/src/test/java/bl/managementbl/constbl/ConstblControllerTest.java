//package bl.managementbl.constbl;
//
//import static org.junit.Assert.*;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.rmi.RemoteException;
//
//import org.junit.Test;
//
//import util.enumData.City;
//import Exception.ConstNotFoundException;
//import VO.ManagementVO.ConstVO;
//
//public class ConstblControllerTest {
//	@Test
//	public void test() {
//		ConstblController constblController = new ConstblController();
//		ConstVO vo = null;
//		ConstVO vo1 = null;
//		try {
//			constblController.insert(new ConstVO(City.SHANGHAI,City.NANJING, 266, 0.023));
//			constblController.insert(new ConstVO(City.GUANGZHOU,City.NANJING, 1132, 0.024));
//			constblController.insert(new ConstVO(City.GUANGZHOU,City.SHANGHAI, 1213, 0.025));
//			constblController.insert(new ConstVO(City.BEIJING,City.GUANGZHOU, 1888.8, 0.021));
//			constblController.insert(new ConstVO(City.BEIJING,City.NANJING, 900, 0.020));
//			constblController.insert(new ConstVO(City.BEIJING,City.SHANGHAI, 1064.7, 0.026));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		}
////		try {
////			vo = constblController.findByCities(City.SHANGHAI,City.NANJING
////					);
////			System.out.println(vo.distanceConst);
//////			assertEquals(266, vo.distanceConst, 0.01);
////			// constbl.delete(vo);
////			vo1 = constblController.findByCities(City.GUANGZHOU,City.SHANGHAI);
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
////		} catch (ConstNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		if (vo1 != null) {
////			assertEquals(0.025, vo1.priceConst, 0.0001);
////		} else {
////			System.out.println("vo is null");
////		}
//	}
//}