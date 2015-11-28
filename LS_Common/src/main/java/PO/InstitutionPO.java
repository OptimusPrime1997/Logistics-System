package PO;

import java.io.Serializable;

public class InstitutionPO implements Serializable,Comparable<InstitutionPO>{
	public final static long serialVersionUID=1L;
	private String instituionNum;
	private String institutionName;
	private String address;
	private String contactInfo;
	private String manning;
	public InstitutionPO(String instituionNum, String institutionName,
			String address, String contactInfo, String manning) {
		super();
		this.instituionNum = instituionNum;
		this.institutionName = institutionName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.manning = manning;
	}

	public String getInstitutionNum() {
		return instituionNum;
	}

	public void setInstituionNum(String instituionNum) {
		this.instituionNum = instituionNum;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getManning() {
		return manning;
	}

	public void setManning(String manning) {
		this.manning = manning;
	}

	@Override
	public int compareTo(InstitutionPO o) {
		// TODO Auto-generated method stub
		return instituionNum.compareTo(o.getInstitutionNum());
	}
}
