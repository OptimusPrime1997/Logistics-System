package bl.managementbl.bankaccountbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.Sex;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.accountbl.AccountList;

public class BankAccountListTest {

	@Test
	public void test() {
		BankAccountVO bAccount1=new BankAccountVO("6212264302009865315", "xx快遞物流公司",1000000);
		BankAccountVO bAccount2=new BankAccountVO("6212264302120165315", "xx快遞物流公司",9100000);
		BankAccountList bankAccountList=new BankAccountList();
		 bankAccountList.addBankAccountVO(bAccount1);
		 bankAccountList.addBankAccountVO(bAccount2);
		assertEquals(2, bankAccountList.getSize());
		System.out.println("The total accounts is:"+ bankAccountList.getSize());
		ArrayList<BankAccountVO> accountArray= bankAccountList.getList();
		for(int i=0;i< bankAccountList.getSize();i++){
			BankAccountVO bankAccount=accountArray.get(i);
			System.out.println(bankAccount.bankAccountNum+" "+bankAccount.bankAccountName+" "+bankAccount.balance);
	}

	}
}