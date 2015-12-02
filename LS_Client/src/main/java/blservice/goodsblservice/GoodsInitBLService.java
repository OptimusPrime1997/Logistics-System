package blservice.goodsblservice;

import util.enumData.ResultMessage;
import Exception.ExistException;
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
	/**
	 * return the fare calculated GoodsVO
	 * @param vo
	 * @return
	 */
	public GoodsVO initCompleteGoods(GoodsVO vo)throws ExistException;


}
