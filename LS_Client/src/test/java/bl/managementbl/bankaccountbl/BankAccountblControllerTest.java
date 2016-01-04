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
					"1234567890123456780", "圆通快递物流第一分公司", 200000));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456781", "圆通快递物流第二分公司", 200001));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456782", "圆通快递物流第三分公司", 200002));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456783", "圆通快递物流第四分公司", 200003));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456784", "圆通快递物流第五分公司", 200004));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456785", "圆通快递物流第六分公司", 200005));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456786", "圆通快递物流第七分公司", 200006));
			BankAccountVO vo = bankAccountblController
					.findByBankAccountNum("1234567890123456781");
//			assertEquals(200001, vo.balance, 0.1);
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
