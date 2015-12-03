package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepPO extends ReceiptPO {
	private String BankAccountNum;
	private String PayPersonNum;
	private ArrayList<LittleThingPO> littleThing;
	private ArrayList<SalaryPO> salary; 
	private ArrayList<TransferPayPO> transferPay;
	private ArrayList<RentPO> rent;
	private ArrayList<DriverSalaryPO> driverSalary;
	private ArrayList<CourierSalaryPO> courierSalary;
	private ArrayList<BonusPO> bouns;
	public PayRepPO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThingPO> littleThing, ArrayList<SalaryPO> salary, ArrayList<TransferPayPO> transferPay,
			ArrayList<RentPO> rent, ArrayList<DriverSalaryPO> driverSalary, ArrayList<CourierSalaryPO> courierSalary,
			ArrayList<BonusPO> bouns) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
		this.driverSalary = driverSalary;
		this.courierSalary = courierSalary;
		this.bouns = bouns;
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
	public ArrayList<DriverSalaryPO> getDriverSalary() {
		return driverSalary;
	}
	public ArrayList<CourierSalaryPO> getCourierSalary() {
		return courierSalary;
	}
	public ArrayList<BonusPO> getBouns() {
		return bouns;
	}
	
}
