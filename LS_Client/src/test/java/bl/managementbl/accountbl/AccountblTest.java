package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import util.enumData.Sex;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;

public class AccountblTest {

	@Test
	public void test() {
		ResultMessage rmsg = null;
		ArrayList<ResultMessage> rmsgs=new ArrayList<ResultMessage>();
		Accountbl accountbl = new Accountbl();
		AccountVO vo = null;
		AccountVO vo1 = null;
		try {
			rmsg = accountbl.add(new AccountVO("02500101001", "王二", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345678901", "025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500102001", "周季", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345678902",
					"025002"));
			rmsgs.add(rmsg);
			
			rmsg = accountbl.add(new AccountVO("02500203001", "王石", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345678903",
					"025002"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500303001", "王一", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345678333",
					"025003"));
			rmsgs.add(rmsg);
			
			rmsg = accountbl.add(new AccountVO("02500104001", "万科", "1111",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345678444",
					"025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500105001", "雷八", "1111",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345678555",
					"025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl
					.add(new AccountVO("02500206001", "周五", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345678666",
							"025002"));
			rmsg = accountbl
					.add(new AccountVO("02500306001", "赵云", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345678666",
							"025003"));
			rmsg = accountbl.add(new AccountVO("02500108001", "张天",
					"1111", Sex.Sex_FAMALE, Authority.ADMINISTRATOR,
					"12345671111", "025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500109001", "王东", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_V, "1234578999",
					"025001"));
			rmsgs.add(rmsg);
			for (int i = 0; i < rmsgs.size(); i++) {
				System.out.println(rmsgs.get(i));
			}
//			vo = accountbl.findByAccountNum("02500101001");
//			System.out.println(vo.accountName);
//			assertEquals("王二", vo.accountName);
//			assertEquals("1111", vo.password);
////			accountbl.delete(vo);
			vo1 = accountbl.findByAccountNum("02500102001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统程序错误！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (vo1 != null) {
//			assertEquals("2222", vo1.password);
//		} else
//			System.out.println("vo1 is null");

	}

}
