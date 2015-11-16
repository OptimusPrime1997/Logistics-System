package bl.formbl;

import VO.BusinessFormVO;
import blservice.formblservice.BusinessFormBLService;

public class BusinessFormController implements BusinessFormBLService{

	private BusinessFormbl businessFormbl = new BusinessFormbl();
	@Override
	public BusinessFormVO show(String startTime, String endTime) {
		return businessFormbl.show(startTime, endTime);
	}

	@Override
	public Boolean save(BusinessFormVO vo) {
		return businessFormbl.save(vo);
	}

}
