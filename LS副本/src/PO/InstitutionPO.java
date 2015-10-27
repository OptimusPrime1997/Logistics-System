package PO;

import java.io.Serializable;

public class InstitutionPO implements Serializable{
	public final static long serialVersionUID=1L;
	private String address;
	private String contactInfo;
	private String manning;

	public InstitutionPO(String address, String contactInfo, String manning) {
		// TODO Auto-generated constructor stub
		this.address = address;
		this.contactInfo = contactInfo;
		this.manning = manning;
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
}
