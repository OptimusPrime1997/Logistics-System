package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.Sex;
import VO.ManagementVO.AccountVO;

public class AccountListTest {

	@Test
	public void test() {
		AccountVO account1=new AccountVO("0250000004", "张三",
				"123456",Sex.Sex_MALE, Authority.COURIER, "18290502356", "南京市栖霞区营业厅");
		AccountVO account2=new AccountVO("0250000014", "王五",
				"123556",Sex.Sex_MALE, Authority.COURIER, "18290502357", "南京市栖霞区营业厅");
		AccountList accountList=new AccountList();
		accountList.addAccount(account1);
		accountList.addAccount(account2);
		assertEquals(2, accountList.getSize());
		System.out.println("The total accounts is:"+accountList.getSize());
		ArrayList<AccountVO> accountArray=accountList.getList();
		for(int i=0;i<accountList.getSize();i++){
			AccountVO person=accountArray.get(i);
			System.out.println(person.accountNum+" "+person.accountName+" "+person.sex.toString()
					+" "+person.authority.toString()+" " +person.phoneNum+" "+person.institution);
		}
	}

}
