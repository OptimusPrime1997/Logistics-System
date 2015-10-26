package PO;

import java.io.Serializable;

public class DriverPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String driverNum;
	private String name;
	private String birthDate;
	private String id;
	private String phoneNum;
	private boolean sex;
	private String licensedTime;
	public DriverPO(String driverNum,String name,String birthDate,String id,String phoneNum, boolean sex,String licensedTime) {
		// TODO Auto-generated constructor stub
		this.driverNum=driverNum;
		this.name=name;
		this.birthDate=birthDate;
		this.id=id;
		this.phoneNum=phoneNum;
		this.sex=sex;
		this.licensedTime=licensedTime;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
	public String getLicensedTime() {
		return licensedTime;
	}
	public void setLicensedTime(String licensedTime) {
		this.licensedTime = licensedTime;
	}

}
