package PO.Receipt;

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
	private PayRepSalaryRepPO staffSalary; 
	private PayRepFreightRepPO freight;
	private PayRepRentRepPO rent;
	private PayRepSalaryRepPO driverSalary;
	private PayRepSalaryRepPO courierSalary;
	private PayRepSalaryRepPO bonus;
	public PayRepPO(String num, String date, double sum, ArrayList<PayPO> payPOs, String payPersonNum,
			ArrayList<PayRepRefundRepPO> refund, PayRepSalaryRepPO staffSalary, PayRepFreightRepPO freight,
			PayRepRentRepPO rent, PayRepSalaryRepPO driverSalary, PayRepSalaryRepPO courierSalary, 
			PayRepSalaryRepPO bonus) {
		super(num, date);
		this.sum = sum;
		this.payPOs = payPOs;
		this.payPersonNum = payPersonNum;
		this.refund = refund;
		this.staffSalary = staffSalary;
		this.freight = freight;
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
	public PayRepSalaryRepPO getStaffSalary() {
		return staffSalary;
	}
	public PayRepFreightRepPO getFreight() {
		return freight;
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
