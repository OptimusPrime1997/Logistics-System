package bl.managementbl.institutionbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.InstitutionVO;
import bl.managementbl.bankaccountbl.BankAccountList;

public class InstitutionListTest {

	@Test
	public void test() {
		InstitutionVO bAccount1=new InstitutionVO("025000010","南京市中转中心","南京市",025-89685204",""), null, null, null)
		InstitutionVO bAccount2=new InstitutionVO("6212264302120165315", "xx快遞物流公司",9100000);
		InstitutionList institutionList=new InstitutionList();
		 institutionList.addInstitutionVO(bAccount1);
		 institutionList.addInstitutionVO(bAccount2);
		assertEquals(2, institutionList.getSize());
		System.out.println("The total institutions is:"+ institutionList.getSize());
		ArrayList<InstitutionVO> accountArray= institutionList.getList();
		for(int i=0;i< institutionList.getSize();i++){
			InstitutionVO institution=accountArray.get(i);
			System.out.println(institution.InstitutionNum+" "+institution.InstitutionName+" "+institution.balance);
	}
}
	}
