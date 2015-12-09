package VO.ManagementVO;

public class VehicleVO implements Comparable<VehicleVO> {
	/**
	 * 车辆编号，3城市+3营业厅+3顺序，如：025001007
	 */
	public String vehicleNum;
	/**
	 * 车牌号，如“苏A88888”
	 */
	public String licenseNum;
	/**
	 * 开始服役时间，如20130101（展示时需转换）
	 */
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
