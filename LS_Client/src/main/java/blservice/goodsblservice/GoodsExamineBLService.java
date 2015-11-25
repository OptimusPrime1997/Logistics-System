package blservice.goodsblservice;

import util.enumData.ResultMessage;

public interface GoodsExamineBLService {

	/**
	 * change the documentCheck state of the list(passed)
	 * @param listNum
	 * @param ifPassed
	 */
	public ResultMessage examine(String listNum,Boolean ifPassed);

}
