package VO;

import java.util.ArrayList;

public class PayRepVO extends ReceiptVO{
	public String BankAccountNum;
	public String PayPersonNum;
	public ArrayList<littleThing> littleThings;
	public ArrayList<Salary> Salary ; //收款人名字、编号；金额
	public ArrayList<TransferPay>TransferPay ;
	public ArrayList<rent> rent ;	
	class Salary{
		String getterName;//收款人名字
		String getterNum;//收款人编号
		String date;
		double money;
	}
	class TransferPay{
		String transferRepNum;//中转单编号
		String date;
		double money;
	}
	class rent{
		String getterName;//收租人姓名
		String phoneNum;
		double money;
		String date;
	}
	class littleThing{
		String date;
		String reason;//付款原因
		double money;
	}
	
}
