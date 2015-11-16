package VO;

import java.util.ArrayList;

public class PayRepVO extends ReceiptVO{
	public String BankAccountNum;
	public String PayPersonNum;
	public ArrayList<littleThing> littleThings;
	public ArrayList<Salary> Salarys ; //收款人名字、编号；金额
	public ArrayList<TransferPay>TransferPays ;
	public ArrayList<rent> rents ;	
	public class Salary{
		public String getterName;//收款人名字
		public String getterNum;//收款人编号
		public String date;
		public double money;
	}
	public class TransferPay{
		public String transferRepNum;//中转单编号
		public String date;
		public double money;
	}
	public class rent{
		public String getterName;//收租人姓名
		public String phoneNum;
		public double money;
		public String date;
	}
	public class littleThing{
		public String date;
		public String reason;//付款原因
		public double money;
	}
	
}
