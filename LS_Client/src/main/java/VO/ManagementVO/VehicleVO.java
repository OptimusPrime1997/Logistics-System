package VO.ManagementVO;

public class VehicleVO implements Comparable<VehicleVO> {
	public String vehicleNum;
	public String licenseNum;
	public String startTime;

	public VehicleVO(String vehicleNum, String licenseNum, String starTime) {
		// TODO Auto-generated constructor stub
		this.vehicleNum = vehicleNum;
		this.licenseNum = licenseNum;
		this.startTime = starTime;
	}

	public int compareTo(VehicleVO v) {
		// TODO Auto-generated method stub
		return vehicleNum.compareTo(v.vehicleNum);
	}
}
