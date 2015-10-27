package VO;

public class PayRepVO extends ReceiptVO{
	String BankAccountNum;
	String PayPersonNum;
	String[] PayThings = new String[3];  //申请时间，原因，金额
	String[] Salary = new String[3];  //收款人名字、编号；金额
	String[] TransferPay = new String[2];  //中转单编号；运费
	String[] rent = new String[3];  //收租人名字，手机；金额
}
