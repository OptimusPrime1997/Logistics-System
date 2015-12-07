package VO.ManagementVO;

import util.enumData.ModifyState;

public class InstitutionVOPlus extends InstitutionVO {
	public ModifyState isModify;

	public InstitutionVOPlus(String institutionNum, String institutionName,
			String contactInfo, String address, String manning,
			ModifyState isModify) {
		super(institutionNum, institutionName, contactInfo, address, manning);
		this.isModify = isModify;
		// TODO Auto-generated constructor stub
	}

	public InstitutionVOPlus(InstitutionVO v, ModifyState isModify) {
		super(v.institutionNum, v.institutionName, v.contactInfo, v.address,
				v.manning);
		this.isModify = isModify;
	}

	public InstitutionVO getInstitutionVO() {
		return new InstitutionVO(institutionNum, institutionName, contactInfo,
				address, manning);
	}

}
