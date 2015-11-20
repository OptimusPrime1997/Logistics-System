package blservice.goodsblservice;

import VO.GoodsVO;

public interface GoodsCheckBLService {
	/**
	 * search for the information of goods by giving the listNumber
	 * @param listNum
	 * @return
	 */
	public GoodsVO check(String listNum);
}
