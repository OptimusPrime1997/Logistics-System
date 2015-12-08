package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.Sex;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;

public class AccountblTest {

	@Test
	public void test() {
		Accountbl accountbl = new Accountbl();
		AccountVO vo = null;
		AccountVO vo1 =null;
		try {
			accountbl.add(new AccountVO("02500101011", "王二", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345678980", "025001"));
			accountbl.add(new AccountVO("02500102022", "周季", "2222",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345678981", "025001"));
			accountbl.add(new AccountVO("02500103033", "王石", "3333",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345678982", "025001"));
			accountbl.add(new AccountVO("02500104044", "大玉儿", "4444",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345678980", "025001"));
			accountbl.add(new AccountVO("02500105055", "刘钦", "5555",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345678981", "025001"));
			accountbl.add(new AccountVO("02500106066", "田田", "6666",
					Sex.Sex_FAMALE, Authority.COURIER, "12345678982", "025001"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统程序错误！");
		}
		try {
			vo = accountbl.findByAccountNum("02500107001");
			System.out.println(vo.accountName);
			assertEquals("王二", vo.accountName);
			// accountbl.delete(vo);
			vo1 = accountbl.findByAccountNum("02500107002");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vo != null) {
			assertEquals("12345678981", vo1.phoneNum);
		} else
			System.out.println("vo is null");

	}

}
