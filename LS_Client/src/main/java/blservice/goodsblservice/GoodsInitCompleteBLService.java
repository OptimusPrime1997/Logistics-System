package blservice.goodsblservice;

import Exception.ExistException;
import VO.GoodsVO;

public interface GoodsInitCompleteBLService {
	/**
	 * return the fare calculated GoodsVO
	 * @param vo
	 * @return
	 */
	public GoodsVO getInitCompleteGoods(GoodsVO vo)throws ExistException;

}
