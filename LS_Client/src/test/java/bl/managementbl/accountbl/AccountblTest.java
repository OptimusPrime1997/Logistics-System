package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.naming.NameNotFoundException;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.Sex;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;

public class AccountblTest {

	@Test
	public void test() {
		Accountbl accountbl = new Accountbl();
		AccountVO vo = null;
		try {
			accountbl
					.add(new AccountVO("025070001", "王五", "12345678",
							Sex.Sex_MALE, Authority.COURIER, "123456789810",
							"02509320"));
			accountbl
					.add(new AccountVO("025070002", "张三", "12345679",
							Sex.Sex_MALE, Authority.COURIER, "123456789811",
							"02509320"));
			accountbl
					.add(new AccountVO("025070003", "王明", "12345670",
							Sex.Sex_MALE, Authority.COURIER, "123456789812",
							"02509320"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = accountbl.findByAccountNum("025070001");
			System.out.println(vo.accountName);
			assertEquals("王五", vo.accountName);
//			accountbl.delete(vo);
			AccountVO vo1 = accountbl.findByAccountNum("025070001");
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
			assertEquals(Sex.Sex_MALE, vo.sex);
		} else
			System.out.println("vo is null");

	}

}
