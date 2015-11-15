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
public interface GoodsBLService {
	/**
	 * search for the information of goods by giving the listNumber
	 * @param listNum
	 * @return
	 */
	public GoodsVO check(String listNum);
	/**
	 * create a list,give the information through GoodsVO
	 * @param vo
	 * @return
	 */
	public Boolean init(GoodsVO vo);
	/**
	 * delete a list 
	 * @param vo
	 * @return
	 */
	public Boolean delete(GoodsVO vo);
	/**
	 * return all the goods started or ended by a courier,whose accountNumber is given
	 * @param CourierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum);
	
	/**
	 * return all the goods started by a courier,whose accountNumber is given
	 * @param CourierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum);
	
	/**
	 * set the arrival state of goods whose listNumber is given
	 * @param listNum
	 * @param state
	 * @return
	 */
	public Boolean setArrivalState(String listNum,GoodsArrivalState state);
	/**
	 * set the logistic state of goods whose listNumber is given
	 * @param listNum
	 * @param state
	 * @return
	 */
	public Boolean setLogisticState(String listNum,GoodsLogisticState state);
	/**
	 * change the documentCheck state of the list(passed)
	 * @param listNum
	 * @param ifPassed
	 */
	public void examine(String listNum,Boolean ifPassed);


}
