package blservice.goodsblservice;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsLogisticState;

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
	public GoodsVO init(GoodsVO vo);
	

	


}
