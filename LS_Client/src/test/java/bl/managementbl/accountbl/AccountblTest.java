//package bl.managementbl.accountbl;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.rmi.RemoteException;
//import org.junit.Test;
//
//import util.enumData.Authority;
//import util.enumData.ResultMessage;
//import util.enumData.Sex;
//import Exception.NumNotFoundException;
//import VO.ManagementVO.AccountVO;
//
//public class AccountblTest {
//
//	@Test
//	public void test() {
//		ResultMessage[] rmsg = new ResultMessage[7];
//		Accountbl accountbl = new Accountbl();
//		AccountVO vo = null;
//		AccountVO vo1 = null;
//		try {
//			rmsg[0] = accountbl.add(new AccountVO("02500101011", "王二", "1111",
//					Sex.Sex_MALE, Authority.MANAGER, "12345678980", "025001"));
//			rmsg[1] = accountbl.add(new AccountVO("02500102022", "周季", "2222",
//					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345678981",
//					"025001"));
//			rmsg[2] = accountbl.add(new AccountVO("02500103033", "王石", "3333",
//					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345678982",
//					"025001"));
//			rmsg[3] = accountbl.add(new AccountVO("02500104044", "大玉儿", "4444",
//					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345678980",
//					"025001"));
//			rmsg[4] = accountbl.add(new AccountVO("02500105055", "刘钦", "5555",
//					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345678981",
//					"025001"));
//			rmsg[5] = accountbl
//					.add(new AccountVO("02500106066", "田田", "6666",
//							Sex.Sex_FAMALE, Authority.COURIER, "12345678982",
//							"025001"));
//			rmsg[6] = accountbl
//					.add(new AccountVO("02500108088", "我是管理员！", "8888",
//							Sex.Sex_FAMALE, Authority.ADMINISTRATOR, "12345678666",
//							"025001"));	
//			
//			for (int i = 0; i < 7; i++) {
//				System.out.println(rmsg[i]);
//			}
//			vo = accountbl.findByAccountNum("02500101011");
//			System.out.println(vo.accountName);
//			assertEquals("王二", vo.accountName);
//			assertEquals("1111", vo.password);
//			accountbl.delete(vo);
//			vo1 = accountbl.findByAccountNum("02500102022");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("系统程序错误！");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		} catch (NumNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (vo1 != null) {
//			assertEquals("2222", vo1.password);
//		} else
//			System.out.println("vo1 is null");
//
//	}
//
//}
