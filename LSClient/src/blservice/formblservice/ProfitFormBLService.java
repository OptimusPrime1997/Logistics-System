package blservice.formblservice;

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
	public Boolean save(ProfitFormVO vo);
	
	
}
