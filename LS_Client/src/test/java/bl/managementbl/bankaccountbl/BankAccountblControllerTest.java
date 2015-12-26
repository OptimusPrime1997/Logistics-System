package bl.managementbl.bankaccountbl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.rmi.RemoteException;


import org.junit.Test;

import Exception.NumNotFoundException;
import VO.ManagementVO.BankAccountVO;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;

public class BankAccountblControllerTest {

	@Test
	public void test() {
		try {
			BankAccountBLService bankAccountblController = new BankAccountblController();
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456780", "第一圆通快递物流公司", 200000));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456781", "第二圆通快递物流公司", 200001));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456782", "第三圆通快递物流公司", 200002));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456783", "第四圆通快递物流公司", 200003));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456784", "第五圆通快递物流公司", 200004));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456785", "第六圆通快递物流公司", 200005));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456786", "第七圆通快递物流公司", 200006));
			BankAccountVO vo = bankAccountblController
					.findByBankAccountNum("1234567890123456781");
			assertEquals(200001, vo.balance, 0.1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统程序错误！");
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
