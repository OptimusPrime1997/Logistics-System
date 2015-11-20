package blservice.goodsblservice;

public interface GoodsExamineBLService {

	/**
	 * change the documentCheck state of the list(passed)
	 * @param listNum
	 * @param ifPassed
	 */
	public void examine(String listNum,Boolean ifPassed);

}
