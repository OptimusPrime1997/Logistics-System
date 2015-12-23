package VO.ManagementVO;

import util.enumData.Sex;

public class DriverVO implements Comparable<DriverVO> {
	/**
	 * 11位 3城市+3营业厅+2人员（07）+3顺序
	 */
	public String driverNum;
	/**
	 * 司机姓名
	 */
	public String name;
	/**
	 * 18位
	 */
	public String id;
	/**
	 * 11位 第一位是1
	 */
	public String phoneNum;
	/**
	 * MALE FALE_MALW
	 */
	public Sex sex;
	/**
	 * valid license time until licensedTime 8位，如19990101
	 */
	public String licensedTime;

	/**
	 * monthly work task
	 */
	public int number;

	public DriverVO(String driverNum, String name, Sex sex, String id,
			String phoneNum, String licensedTime, int number) {
		// TODO Auto-generated constructor stub
		this.driverNum = driverNum;
		this.name = name;
		this.id = id;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.licensedTime = licensedTime;
		this.number = number;
	}

	public int compareTo(DriverVO v) {
		// TODO Auto-generated method stub
		return driverNum.compareTo(driverNum);
	}
}
