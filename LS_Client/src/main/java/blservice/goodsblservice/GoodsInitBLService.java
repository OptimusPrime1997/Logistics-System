package blservice.goodsblservice;

import util.enumData.ResultMessage;
import VO.GoodsVO;

/**
 * 
 * @author Administrator
 *
 */
public interface GoodsInitBLService {
	
	/**
	 * create a list,give the information through GoodsVO
	 * @param vo
	 * @return
	 */
	public ResultMessage init(GoodsVO vo);
	

	


}
