package VO.ManagementVO;

public class InstitutionVO implements Comparable<InstitutionVO> {
	/**
	 * 机构编号，如 3城市+3顺序，025001
	 */
	public String institutionNum;
	/**
	 * 机构名称，如：南京市栖霞区营业厅
	 */
	public String institutionName;
	/**
	 * 地址，如：南京市栖霞区仙林大道163号
	 */
	public String address;
	/**
	 * 机构电话，如：02589689345
	 */
	public String contactInfo;
	/**
	 * 机构人员组成，如：张三，李四（中间用英文逗号间隔）
	 */
	public String manning;

	public InstitutionVO(String institutionNum, String institutionName,
			String contactInfo, String address, String manning) {
		super();
		this.institutionNum = institutionNum;
		this.institutionName = institutionName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.manning = manning;
	}

	public int compareTo(InstitutionVO v) {
		// TODO Auto-generated method stub
		return institutionNum.compareTo(v.institutionNum);
	}

	public boolean equals(InstitutionVO v) {
		if (institutionNum.equals(v.institutionNum)
				&& institutionName.equals(v.institutionName)
				&& address.equals(v.address)
				&& contactInfo.equals(v.contactInfo)
				&& manning.equals(v.manning)) {
			return true;
		} else {
			return false;
		}
	}

}
