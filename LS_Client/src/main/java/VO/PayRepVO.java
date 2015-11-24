package VO;

import java.util.ArrayList;

import PO.PayRepPO;
<<<<<<< HEAD
import PO.ReceiptPO;
=======
<<<<<<< HEAD
import PO.ReceiptPO;
=======
>>>>>>> origin/master
>>>>>>> origin/master

public class PayRepVO extends ReceiptVO {
	public String BankAccountNum;
	public String PayPersonNum;
	public ArrayList<LittleThingVO> littleThing;
	public ArrayList<SalaryVO> salary; 
	public ArrayList<TransferPayVO> transferPay;
	public ArrayList<RentVO> rent;
<<<<<<< HEAD


=======

<<<<<<< HEAD

>>>>>>> origin/master
	public PayRepVO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThingVO> littleThing, ArrayList<SalaryVO> salary, ArrayList<TransferPayVO> transferPay,
			ArrayList<RentVO> rent) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
<<<<<<< HEAD
=======
=======
	public static ArrayList<PayRepPO> toPOArray(ArrayList<PayRepVO> vos){
		ArrayList<PayRepPO> pos=new ArrayList<PayRepPO>();
		//TODO	
		return pos;
	}
	public static ArrayList<PayRepVO> toVOArray(ArrayList<PayRepPO> pos){
		ArrayList<PayRepVO> vos=new ArrayList<PayRepVO>();
		//TODO	
		return vos;
	}
	
	public class Salary {
		public String getterName;
		public String getterNum;
		public String date;
		public double money;
		
		public Salary(String getterName, String getterNum, String date, double money) {
			super();
			this.getterName = getterName;
			this.getterNum = getterNum;
			this.date = date;
			this.money = money;
		}
		
>>>>>>> origin/master
>>>>>>> origin/master
	}

	public String getBankAccountNum() {
		return BankAccountNum;
	}

	public String getPayPersonNum() {
		return PayPersonNum;
	}

	public ArrayList<LittleThingVO> getLittleThing() {
		return littleThing;
	}

	public ArrayList<SalaryVO> getSalary() {
		return salary;
	}

	public ArrayList<TransferPayVO> getTransferPay() {
		return transferPay;
<<<<<<< HEAD
	}

	public ArrayList<RentVO> getRent() {
		return rent;
	}

=======
	}

	public ArrayList<RentVO> getRent() {
		return rent;
	}

>>>>>>> origin/master
	public PayRepVO(PayRepPO po){
		this.BankAccountNum = po.getBankAccountNum();
		this.PayPersonNum = po.getPayPersonNum();
		this.littleThing = LittleThingVO.toArrayVO(po.getLittleThing());
		this.salary = SalaryVO.toArrayVO(po.getSalary());
		this.transferPay = TransferPayVO.toArrayVO(po.getTransferPay());
		this.rent = RentVO.toArrayVO(po.getRent());
	}
	
	public static PayRepPO toPO (PayRepVO vo){
		return new PayRepPO(vo.num, vo.date, vo.BankAccountNum, vo.PayPersonNum, 
				LittleThingVO.toArrayPO(vo.littleThing), SalaryVO.toArrayPO(vo.salary), 
				TransferPayVO.toArrayPO(vo.transferPay), RentVO.toArrayPO(vo.rent));
	}
	
	public static ArrayList<PayRepVO> toArrayVO(ArrayList<PayRepPO> payrepPOs){
		ArrayList<PayRepVO> payRepVOs  = new ArrayList<PayRepVO>();
		for(PayRepPO payRepPO : payrepPOs){
			payRepVOs.add(new PayRepVO(payRepPO));
		}
		return payRepVOs;
	}
	
	public static ArrayList<PayRepPO> toArrayPO(ArrayList<PayRepVO> payrepVOs){
		ArrayList<PayRepPO> payRepPOs  = new ArrayList<PayRepPO>();
		for(PayRepVO payRepVO : payrepVOs){
			payRepPOs.add(PayRepVO.toPO(payRepVO));
		}
		return payRepPOs;
	}
}
