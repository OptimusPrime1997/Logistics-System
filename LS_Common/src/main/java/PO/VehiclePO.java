package PO;

import java.io.Serializable;

public class VehiclePO implements Serializable,Comparable<VehiclePO>{
	public final static long serialVersionUID=1L;
	private String vehicleNum;
	private String licenseNum;
	private String startTime;
	public VehiclePO(String vehicleNum,String licenseNum,String starTime) {
		// TODO Auto-generated constructor stub
		this.vehicleNum=vehicleNum;
		this.licenseNum=licenseNum;
		this.startTime=(starTime);
		
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

public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
@Override
public int compareTo(VehiclePO o) {
	// TODO Auto-generated method stub
	return vehicleNum.compareTo(o.getVehicleNum());
}
}
