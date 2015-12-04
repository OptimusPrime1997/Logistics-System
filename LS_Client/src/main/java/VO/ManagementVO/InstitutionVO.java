package VO.ManagementVO;

public class InstitutionVO implements Comparable<InstitutionVO>{
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
	public int compareTo(InstitutionVO v) {
		// TODO Auto-generated method stub
		return institutionNum.compareTo(v.institutionNum);
	}
	
	
}
