package VO.ManagementVO;

public class InstitutionVO {
	public String institutionName;
	public String address;
	public String contactInfo;
	public String manning;
	public InstitutionVO(String institutionName, String address,
			String contactInfo, String manning) {
		super();
		this.institutionName = institutionName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.manning = manning;
	}

	
}
