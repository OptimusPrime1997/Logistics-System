package PO;

import java.io.Serializable;

import util.enumData.Sex;

public class DriverPO implements Serializable, Comparable<DriverPO> {
	private static final long serialVersionUID = 1L;
	private String driverNum;
	private String name;
	private String id;
	private String phoneNum;
	private Sex sex;
	private String licensedTime;
	private int number;

	public DriverPO(String driverNum, String name, Sex sex, String id,
			String phoneNum, String licensedTime, int number) {
		// TODO Auto-generated constructor stub
		this.driverNum = driverNum;
		this.name = name;
		this.id = id;
		this.phoneNum = phoneNum;
		this.setSex(sex);
		this.licensedTime = licensedTime;
		this.number = number;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getLicensedTime() {
		return licensedTime;
	}

	public void setLicensedTime(String licensedTime) {
		this.licensedTime = licensedTime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(DriverPO o) {
		// TODO Auto-generated method stub
		return driverNum.compareTo(o.getDriverNum());
	}

}
