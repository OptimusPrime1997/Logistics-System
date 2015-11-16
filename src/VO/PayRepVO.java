package VO;

public class PayRepVO extends ReceiptVO{
	public String BankAccountNum;
	public String PayPersonNum;
	public String[] PayThings = new String[3];  //申请时间，原因，金额
	public String[] Salary = new String[3];  //收款人名字、编号；金额
	public String[] TransferPay = new String[2];  //中转单编号；运费
	public String[] rent = new String[3];  //收租人名字，手机；金额
}
