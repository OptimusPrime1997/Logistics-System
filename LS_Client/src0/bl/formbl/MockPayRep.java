package bl.formbl;

import java.util.ArrayList;

import VO.PayRepVO;
import VO.PayRepVO.LittleThing;
import VO.PayRepVO.Rent;
import VO.PayRepVO.Salary;
import VO.PayRepVO.TransferPay;
import bl.receiptbl.PayRepbl.PayRepbl;

public class MockPayRep extends PayRepbl {

	public ArrayList<PayRepVO> get() {
		ArrayList<PayRepVO> vos=new ArrayList<PayRepVO>();
		PayRepVO pVO=new PayRepVO("", "",null,null,null,null);
		ArrayList<Salary> salarys=new ArrayList<Salary>();
		ArrayList<Rent> rents=new ArrayList<Rent>();
		ArrayList<TransferPay> trs=new ArrayList<TransferPay>();
		ArrayList<LittleThing> lits=new ArrayList<LittleThing>();
		
		Salary salary0= pVO.new Salary();salary0.money=5000;salarys.add(salary0);
		Salary salary1= pVO.new Salary();salary1.money=3000;salarys.add(salary1);
		Salary salary2= pVO.new Salary();salary2.money=5000;salarys.add(salary2);
		Salary salary3= pVO.new Salary();salary3.money=6000;salarys.add(salary3);
		Salary salary4= pVO.new Salary();salary4.money=5000;salarys.add(salary4);
		Salary salary5= pVO.new Salary();salary5.money=5000;salarys.add(salary5);//45500
		Salary salary6= pVO.new Salary();salary6.money=2000;salarys.add(salary6);
		Salary salary7= pVO.new Salary();salary7.money=1500;salarys.add(salary7);
		Salary salary8= pVO.new Salary();salary8.money=8000;salarys.add(salary8);
		Salary salary9= pVO.new Salary();salary9.money=5000;salarys.add(salary9);
		
		Rent rent0= pVO.new Rent();rent0.money=1000;rents.add(rent0);
		Rent rent1= pVO.new Rent();rent1.money=1500;rents.add(rent1);//4500
		Rent rent2= pVO.new Rent();rent2.money=2000;rents.add(rent2);
		
		TransferPay tr0=pVO.new TransferPay();tr0.money=1200;trs.add(tr0);//1200
		
		LittleThing li0=pVO.new LittleThing();li0.money=100;lits.add(li0);//100
		
		
				
		
		PayRepVO vo1=new PayRepVO("123", "11144400022255", lits, salarys, trs, rents);
		vos.add(vo1);
		return vos;
	}
}
