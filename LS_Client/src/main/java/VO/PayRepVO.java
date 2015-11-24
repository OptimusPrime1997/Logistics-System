package VO;

import java.util.ArrayList;

import PO.PayRepPO;

public class PayRepVO extends ReceiptVO {
	public String BankAccountNum;
	public String PayPersonNum;
	public ArrayList<LittleThing> littleThings;
	public ArrayList<Salary> Salarys; 
	public ArrayList<TransferPay> TransferPays;
	public ArrayList<Rent> rents;

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
		
	}

	public class TransferPay {
		public String transferRepNum;
		public String date;
		public double money;
		
		public TransferPay(String transferRepNum, String date, double money) {
			super();
			this.transferRepNum = transferRepNum;
			this.date = date;
			this.money = money;
		}
		
	}

	public class Rent {
		public String getterName;
		public String phoneNum;
		public double money;
		public String date;
		
		public Rent(String getterName, String phoneNum, double money, String date) {
			super();
			this.getterName = getterName;
			this.phoneNum = phoneNum;
			this.money = money;
			this.date = date;
		}
	}

	public class LittleThing {
		public String date;
		public String reason;
		public double money;
		
		public LittleThing(String date, String reason, double money) {
			super();
			this.date = date;
			this.reason = reason;
			this.money = money;
		}
	}

	public PayRepVO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThing> littleThings, ArrayList<Salary> salarys, ArrayList<TransferPay> transferPays,
			ArrayList<Rent> rents) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThings = littleThings;
		Salarys = salarys;
		TransferPays = transferPays;
		this.rents = rents;
	}

}
