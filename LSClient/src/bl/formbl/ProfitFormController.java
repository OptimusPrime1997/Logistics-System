package bl.formbl;

import VO.ProfitFormVO;
import blservice.formblservice.ProfitFormBLService;

public class ProfitFormController implements ProfitFormBLService{
	private ProfitFormbl profitFormbl = new ProfitFormbl();
	@Override
	public ProfitFormVO show() {
		return profitFormbl.show();
	}

	@Override
	public Boolean save(ProfitFormVO vo) {
		return profitFormbl.save(vo);
	}

}
