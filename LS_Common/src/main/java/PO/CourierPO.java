package PO;

import java.io.Serializable;

/**
 * @author 1
 *存储快递员编号 和 当月业务金额
 */
public class CourierPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 快递员编号
	 */
	private String courierNum;
	/**
	 * 快递员当月收件、派件总金额
	 */
	private double courrentMonthMoney;

	public CourierPO(String courierNum, double courrentMonthMoney) {
		super();
		this.courierNum = courierNum;
		this.courrentMonthMoney = courrentMonthMoney;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public double getCourrentMonthMoney() {
		return courrentMonthMoney;
	}

	public void setCourrentMonthMoney(int courrentMonthMoney) {
		this.courrentMonthMoney = courrentMonthMoney;
	}

}
