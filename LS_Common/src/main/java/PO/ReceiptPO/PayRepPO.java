package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepPO extends ReceiptPO {
	private double sum;
	private ArrayList<PayPO> payPOs;
	private String payPersonNum;
	private ArrayList<LittleThingRepPO> littleThing;
	private AllSalaryRepPO salary; 
	private TransferPayRepPO transferPay;
	private RentRepPO rent;
	private AllSalaryRepPO driverSalary;
	private AllSalaryRepPO courierSalary;
	private AllSalaryRepPO bonus;
	public PayRepPO(String num, String date, double sum, ArrayList<PayPO> payPOs, String payPersonNum,
			ArrayList<LittleThingRepPO> littleThing, AllSalaryRepPO salary, TransferPayRepPO transferPay, RentRepPO rent,
			AllSalaryRepPO driverSalary, AllSalaryRepPO courierSalary, AllSalaryRepPO bonus) {
		super(num, date);
		this.sum = sum;
		this.payPOs = payPOs;
		this.payPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
		this.driverSalary = driverSalary;
		this.courierSalary = courierSalary;
		this.bonus = bonus;
	}
	public double getSum() {
		return sum;
	}
	public ArrayList<PayPO> getPayPOs() {
		return payPOs;
	}
	public String getPayPersonNum() {
		return payPersonNum;
	}
	public ArrayList<LittleThingRepPO> getLittleThing() {
		return littleThing;
	}
	public AllSalaryRepPO getSalary() {
		return salary;
	}
	public TransferPayRepPO getTransferPay() {
		return transferPay;
	}
	public RentRepPO getRent() {
		return rent;
	}
	public AllSalaryRepPO getDriverSalary() {
		return driverSalary;
	}
	public AllSalaryRepPO getCourierSalary() {
		return courierSalary;
	}
	public AllSalaryRepPO getBonus() {
		return bonus;
	}

	
}
