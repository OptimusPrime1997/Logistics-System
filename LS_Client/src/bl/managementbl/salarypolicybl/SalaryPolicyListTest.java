package bl.managementbl.salarypolicybl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import util.enumData.SalaryPolicy;
import VO.ManagementVO.SalaryPolicyVO;

public class SalaryPolicyListTest {

	@Test
	public void test() {
		SalaryPolicyVO salary1=new SalaryPolicyVO(SalaryPolicy.ADMINISTRATOR_SP,6000.0);	
		SalaryPolicyVO salary2=new SalaryPolicyVO(SalaryPolicy.BUSSINESSOFFICER_SP,7000.0);	
		SalaryPolicyList institutionList=new SalaryPolicyList();
		 institutionList.addSalaryPolicyVO(salary1);
		 institutionList.addSalaryPolicyVO(salary2);
		assertEquals(2, institutionList.getSize());
		System.out.println("The total institutions is:"+ institutionList.getSize());
		ArrayList<SalaryPolicyVO> accountArray= institutionList.getList();
		for(int i=0;i< institutionList.getSize();i++){
			SalaryPolicyVO salary=accountArray.get(i);
			System.out.println(salary.salaryPolicy.toString()+" "+salary.salaryAmount);
	}


	}
}
