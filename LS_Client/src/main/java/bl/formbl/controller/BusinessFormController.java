package bl.formbl.controller;

import VO.BusinessFormVO;
import bl.formbl.BusinessFormbl;
import blservice.formblservice.BusinessFormBLService;

public class BusinessFormController implements BusinessFormBLService{

	private BusinessFormbl businessFormbl = new BusinessFormbl();

	public BusinessFormVO show(String startTime, String endTime) {
		return businessFormbl.show(startTime, endTime);
	}

	public Boolean save(BusinessFormVO vo) {
		return businessFormbl.save(vo);
	}

}
