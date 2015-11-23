package bl.formbl.controller;

import VO.ProfitFormVO;
import bl.formbl.ProfitFormbl;
import blservice.formblservice.ProfitFormBLService;

public class ProfitFormController implements ProfitFormBLService{
	private ProfitFormbl profitFormbl = new ProfitFormbl();

	public ProfitFormVO show() {
		return profitFormbl.show();
	}

	public Boolean save(ProfitFormVO vo) {
		return profitFormbl.save(vo);
	}

}
