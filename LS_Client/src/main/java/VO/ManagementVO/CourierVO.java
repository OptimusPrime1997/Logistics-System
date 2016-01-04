package VO.ManagementVO;

import util.InputCheck;

public class CourierVO implements Comparable<CourierVO> {
	/**
	 * 快递员编号
	 */
	public String courierNum;
	/**
	 * 快递员当月收件、派件总金额
	 */
	public double courrentMonthMoney;

	public CourierVO(String courierNum, double courrentMonthMoney) {
		super();
		this.courierNum = courierNum;
		this.courrentMonthMoney = InputCheck.formatDouble(courrentMonthMoney);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 按编号排序
	 */
	@Override
	public int compareTo(CourierVO o) {
		// TODO Auto-generated method stub
		return courierNum.compareTo(o.courierNum);
	}

}
