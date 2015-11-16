package VO.ManagementVO;

public class InstitutionVO {
	public String institutionNum;
	public String institutionName;
	public String address;
	public String contactInfo;
	public String manning;
	public InstitutionVO(String institutionNum, String institutionName,
			String address, String contactInfo, String manning) {
		super();
		this.institutionNum = institutionNum;
		this.institutionName = institutionName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.manning = manning;
	}
	
	
}
