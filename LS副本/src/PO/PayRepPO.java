package PO;

public class PayRepPO extends ReceiptPO {
	private String BankAccountNum;
	private String PayPersonNum;
	private String[] PayThings = new String[3];  //申请时间，原因，金额
	private String[] Salary = new String[3];  //收款人名字、编号；金额
	private String[] TransferPay = new String[2];  //中转单编号；运费
	private String[] rent = new String[3];  //收租人名字，手机；金额
	public PayRepPO(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		PayThings = payThings;
		Salary = salary;
		TransferPay = transferPay;
		this.rent = rent;
	}
	public String getBankAccountNum() {
		return BankAccountNum;
	}
	public String getPayPersonNum() {
		return PayPersonNum;
	}
	public String[] getPayThings() {
		return PayThings;
	}
	public String[] getSalary() {
		return Salary;
	}
	public String[] getTransferPay() {
		return TransferPay;
	}
	public String[] getRent() {
		return rent;
	}
	
}
