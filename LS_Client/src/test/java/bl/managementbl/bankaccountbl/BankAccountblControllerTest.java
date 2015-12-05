package bl.managementbl.bankaccountbl;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.naming.NameNotFoundException;

import org.junit.Test;

import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import Exception.NumNotFoundException;
import PO.BankAccountPO;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.managedata.ManageData;
import blservice.managementblservice.bankaccountblservice.BankAccountBLService;

public class BankAccountblControllerTest {

	@Test
	public void test() {
		try {
			BankAccountBLService bankAccountblController = new BankAccountblController();
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456780", "圆通快递物流公司", 200000));
			bankAccountblController.insert(new BankAccountVO(
					"1234567890123456781", "圆通快递物流公司", 200001));
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
