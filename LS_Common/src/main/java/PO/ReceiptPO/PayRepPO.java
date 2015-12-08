package PO.ReceiptPO;

import java.util.ArrayList;

public class PayRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -996965091924001792L;
	
	private double sum;
	private ArrayList<PayPO> payPOs;
	private String payPersonNum;
	private ArrayList<PayRepRefundRepPO> refund;
	private PayRepSalaryRepPO salary; 
	private PayRepFreightRepPO transferPay;
	private PayRepRentRepPO rent;
	private PayRepSalaryRepPO driverSalary;
	private PayRepSalaryRepPO courierSalary;
	private PayRepSalaryRepPO bonus;
	public PayRepPO(String num, String date, double sum, ArrayList<PayPO> payPOs, String payPersonNum,
			ArrayList<PayRepRefundRepPO> refund, PayRepSalaryRepPO salary, PayRepFreightRepPO transferPay, PayRepRentRepPO rent,
			PayRepSalaryRepPO driverSalary, PayRepSalaryRepPO courierSalary, PayRepSalaryRepPO bonus) {
		super(num, date);
		this.sum = sum;
		this.payPOs = payPOs;
		this.payPersonNum = payPersonNum;
		this.refund = refund;
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
	public ArrayList<PayRepRefundRepPO> getRefund() {
		return refund;
	}
	public PayRepSalaryRepPO getSalary() {
		return salary;
	}
	public PayRepFreightRepPO getTransferPay() {
		return transferPay;
	}
	public PayRepRentRepPO getRent() {
		return rent;
	}
	public PayRepSalaryRepPO getDriverSalary() {
		return driverSalary;
	}
	public PayRepSalaryRepPO getCourierSalary() {
		return courierSalary;
	}
	public PayRepSalaryRepPO getBonus() {
		return bonus;
	}

	
}
