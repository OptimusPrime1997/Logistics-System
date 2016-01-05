//package bl.managementbl.accountbl;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
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
//		ResultMessage rmsg = null;
//		ArrayList<ResultMessage> rmsgs = new ArrayList<ResultMessage>();
//		Accountbl accountbl = new Accountbl();
//		AccountVO vo = null;
//		AccountVO vo1 = null;
//		try {
////			rmsg = accountbl.add(new AccountVO("02500001001", "南总理", "1111", Sex.Sex_MALE, Authority.MANAGER,
////					"12345672501", "025000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500002001", "南普财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_C,
////					"12345672502", "025000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500103001", "南营一", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672503", "025001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500203001", "南营二", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672510", "025002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500004001", "南中转", "1111", Sex.Sex_MALE, Authority.TRANSFERCTROFFICER,
////					"12345672504", "025000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500005001", "南仓库", "1111", Sex.Sex_MALE, Authority.WAREHOUSEMAN,
////					"12345672505", "025000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500106001", "南快一", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672506", "025001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500206001", "南快二", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672511", "025002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500008001", "南管理", "1111", Sex.Sex_FAMALE, Authority.ADMINISTRATOR,
////					"12345672512", "025000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02500009001", "南高财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_V,
////					"12345672509", "025000"));
////			rmsgs.add(rmsg);
////			
////			rmsg = accountbl.add(new AccountVO("02100001001", "上总理", "1111", Sex.Sex_MALE, Authority.MANAGER,
////					"12345672101", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100002001", "上普财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_C,
////					"12345672102", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100103001", "上营一", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672103", "021001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100203001", "上营二", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672110", "021002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100004001", "上中转", "1111", Sex.Sex_MALE, Authority.TRANSFERCTROFFICER,
////					"12345672104", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100005001", "上仓库", "1111", Sex.Sex_MALE, Authority.WAREHOUSEMAN,
////					"12345672105", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100106001", "上快一", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672106", "021001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100206001", "上快二", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672111", "021002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100008001", "上管理", "1111", Sex.Sex_FAMALE, Authority.ADMINISTRATOR,
////					"12345672112", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02100009001", "上高财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_V,
////					"12345672109", "021000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000001001", "广总理", "1111", Sex.Sex_MALE, Authority.MANAGER,
////					"12345672001", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000002001", "广普财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_C,
////					"12345672002", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000103001", "广营一", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672003", "020001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000203001", "广营二", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345672010", "020002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000004001", "广中转", "1111", Sex.Sex_MALE, Authority.TRANSFERCTROFFICER,
////					"12345672004", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000005001", "广仓库", "1111", Sex.Sex_MALE, Authority.WAREHOUSEMAN,
////					"12345672005", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000106001", "广快一", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672006", "020001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000206001", "广快二", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345672011", "020002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000008001", "广管理", "1111", Sex.Sex_FAMALE, Authority.ADMINISTRATOR,
////					"12345672012", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("02000009001", "广高财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_V,
////					"12345672009", "020000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000001001", "北总理", "1111", Sex.Sex_MALE, Authority.MANAGER,
////					"12345671001", "010000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000001001", "北普财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_C,
////					"12345671002", "010000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000103001", "北营一", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345671003", "010001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000203001", "北营二", "1111", Sex.Sex_MALE, Authority.BUSSINESSOFFICER,
////					"12345671010", "010002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000004001", "北中转", "1111", Sex.Sex_MALE, Authority.TRANSFERCTROFFICER,
////					"12345671004", "010000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000005001", "北仓库", "1111", Sex.Sex_MALE, Authority.WAREHOUSEMAN,
////					"12345671005", "010000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000106001", "北快一", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345671006", "010001"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000206001", "北快二", "1111", Sex.Sex_FAMALE, Authority.COURIER,
////					"12345671011", "010002"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000008001", "北管理", "1111", Sex.Sex_FAMALE, Authority.ADMINISTRATOR,
////					"12345671012", "010000"));
////			rmsgs.add(rmsg);
////			rmsg = accountbl.add(new AccountVO("01000009001", "北高财", "1111", Sex.Sex_MALE, Authority.FINANCIALSTAFF_V,
////					"12345671009", "010000"));
////			rmsgs.add(rmsg);
//			
//			
//			
//			
//			rmsg = accountbl.add(new AccountVO("02500106066", "南快四", "1111", Sex.Sex_MALE, Authority.COURIER,
//					"12345672513", "025001"));
//			rmsgs.add(rmsg);
//			for (int i = 0; i < rmsgs.size(); i++) {
//				System.out.println(rmsgs.get(i));
//			}
//			// vo = accountbl.findByAccountNum("02500101001");
//			// System.out.println(vo.accountName);
//			// assertEquals("王二", vo.accountName);
//			// assertEquals("1111", vo.password);
//			// // accountbl.delete(vo);
//			vo1 = accountbl.findByAccountNum("02500001001");
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
//		// if (vo1 != null) {
//		// assertEquals("2222", vo1.password);
//		// } else
//		// System.out.println("vo1 is null");
//
//	}
//
//}
