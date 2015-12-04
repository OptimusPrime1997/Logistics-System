package VO.ManagementVO;

import util.enumData.Sex;

public class DriverVO implements Comparable<DriverVO> {
	public String driverNum;
	public String name;
	public String birthDate;
	public String id;
	public String phoneNum;
	public Sex sex;
	/**
	 * valid license time until licensedTime
	 */
	public String licensedTime;

	public DriverVO(String driverNum, String name, String birthDate, String id,
			String phoneNum, Sex sex, String licensedTime) {
		// TODO Auto-generated constructor stub
		this.driverNum = driverNum;
		this.name = name;
		this.birthDate = birthDate;
		this.id = id;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.licensedTime = licensedTime;
	}

	public int compareTo(DriverVO v) {
		// TODO Auto-generated method stub
		return driverNum.compareTo(driverNum);
	}
}
