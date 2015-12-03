package blservice.goodsblservice;

import util.enumData.ResultMessage;
import Exception.GoodsNotFound;
import VO.GoodsVO;

public interface GoodsDeleteBLService {
	/**
	 * delete a list 
	 * @param vo
	 * @return
	 * @throws GoodsNotFound 
	 */
	public ResultMessage delete(GoodsVO vo) throws GoodsNotFound;
}
