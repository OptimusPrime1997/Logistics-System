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
	public void test()  {
		Accountbl accountbl = new Accountbl();
		AccountVO vo = null;
		try {
			accountbl
					.add(new AccountVO("02500107001", "王二", "12345678",
							Sex.Sex_MALE, Authority.COURIER, "123456789810",
							"025001"));
			accountbl
					.add(new AccountVO("02500107002", "周季", "12345679",
							Sex.Sex_MALE, Authority.COURIER, "123456789811",
							"025001"));
			accountbl
					.add(new AccountVO("02500107003", "王石", "12345670",
							Sex.Sex_MALE, Authority.COURIER, "123456789812",
							"025001"));
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
			assertEquals("王五", vo.accountName);
//			accountbl.delete(vo);
			AccountVO vo1 = accountbl.findByAccountNum("02500107001");
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
