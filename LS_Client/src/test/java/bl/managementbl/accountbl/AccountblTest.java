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
			accountbl.add(new AccountVO("025123456", "accountName", "password",
					Sex.Sex_FAMALE, Authority.COURIER, "123456789810",
					"0259320"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		}
		try {
			vo = accountbl.findByAccountNum("025123456");
			System.out.println(vo.accountName);
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
