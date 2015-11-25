package blservice.formblservice;

import util.enumData.ResultMessage;
import VO.ProfitFormVO;

public interface ProfitFormBLService {
	/**
	 * return a profitForm.
	 * @return
	 */
	public ProfitFormVO show();
	/**
	 * save the profitForm the local
	 * @param vo
	 * @return
	 */
	public ResultMessage save(ProfitFormVO vo);
	
	
}
