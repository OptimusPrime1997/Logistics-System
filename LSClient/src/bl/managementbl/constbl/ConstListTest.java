package bl.managementbl.constbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.ConstVO;
import bl.managementbl.bankaccountbl.BankAccountList;

public class ConstListTest {

	@Test
	public void test() {
		ConstVO const1=new ConstVO("南京/上海",900,0.0023);
		ConstVO const2=new ConstVO("广州/南京",1200,0.0025);
		ConstList constList=new ConstList();
		 constList.addConstVO(const1);
		 constList.addConstVO(const2);
		assertEquals(2, constList.getSize());
		System.out.println("The total accounts is:"+ constList.getSize());
		ArrayList<ConstVO> accountArray= constList.getList();
		for(int i=0;i< constList.getSize();i++){
			ConstVO c=accountArray.get(i);
			System.out.println(c.twoCities+" "+c.distanceConst+" "+c.priceConst);
	}
	}

}
