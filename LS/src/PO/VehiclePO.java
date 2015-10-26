package PO;

import java.io.Serializable;

public class VehiclePO implements Serializable{
	public final static long serialVersionUID=1L;
	private String vehicleNum;
	private String licenseNum;
	private String attendTime;
	public VehiclePO(String vehicleNum,String licenseNum,String attendTime) {
		// TODO Auto-generated constructor stub
		this.vehicleNum=vehicleNum;
		this.licenseNum=licenseNum;
		this.attendTime=attendTime;
		
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
public void setVehicleNum(String vehicleNum) {
	this.vehicleNum = vehicleNum;
}
public String getLicenseNum() {
	return licenseNum;
}
public void setLicenseNum(String licenseNum) {
	this.licenseNum = licenseNum;
}
public String getAttendTime() {
	return attendTime;
}
public void setAttendTime(String attendTime) {
	this.attendTime = attendTime;
}
}
