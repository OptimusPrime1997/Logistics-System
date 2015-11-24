package PO;

import java.util.ArrayList;

public class PayRepPO extends ReceiptPO {
	private String BankAccountNum;
	private String PayPersonNum;
	private ArrayList<LittleThingPO> littleThing;
	private ArrayList<SalaryPO> salary; 
	private ArrayList<TransferPayPO> transferPay;
	private ArrayList<RentPO> rent;
	public PayRepPO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThingPO> littleThing, ArrayList<SalaryPO> salary, ArrayList<TransferPayPO> transferPay,
			ArrayList<RentPO> rent) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
	}
	public String getBankAccountNum() {
		return BankAccountNum;
	}
	public String getPayPersonNum() {
		return PayPersonNum;
	}
	public ArrayList<LittleThingPO> getLittleThing() {
		return littleThing;
	}
	public ArrayList<SalaryPO> getSalary() {
		return salary;
	}
	public ArrayList<TransferPayPO> getTransferPay() {
		return transferPay;
	}
	public ArrayList<RentPO> getRent() {
		return rent;
	}

}
