package bl.managementbl.institutionbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import VO.ManagementVO.InstitutionVO;

public class InstitutionListTest {

	@Test
	public void test() {
		InstitutionVO bAccount1=new InstitutionVO("025000010","南京市中转中心","南京市栖霞区仙林大道163号","025-89685204","张三/王五");
		InstitutionVO bAccount2=new InstitutionVO("285000018","广州市中转中心","广州市栖霞区仙林大道163号","095-89685204","张三/王五");
		InstitutionList institutionList=new InstitutionList();
		 institutionList.addInstitutionVO(bAccount1);
		 institutionList.addInstitutionVO(bAccount2);
		assertEquals(2, institutionList.getSize());
		System.out.println("The total institutions is:"+ institutionList.getSize());
		ArrayList<InstitutionVO> accountArray= institutionList.getList();
		for(int i=0;i< institutionList.getSize();i++){
			InstitutionVO institution=accountArray.get(i);
			System.out.println(institution.institutionNum+" "+institution.institutionName+
					" "+institution.address+" "+institution.contactInfo+" "+institution.manning);
	}


	}
	}
