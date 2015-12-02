package blservice.goodsblservice;

import Exception.GoodsNotFound;
import VO.GoodsVO;

public interface GoodsCheckBLService {
	/**
	 * search for the information of goods by giving the listNumber
	 * @param listNum
	 * @return
	 */
	public GoodsVO check(String listNum)throws GoodsNotFound;
}
