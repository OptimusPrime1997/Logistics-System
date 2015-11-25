package blservice.goodsblservice;

import util.enumData.ResultMessage;
import VO.GoodsVO;

public interface GoodsDeleteBLService {
	/**
	 * delete a list 
	 * @param vo
	 * @return
	 */
	public ResultMessage delete(GoodsVO vo);
}
