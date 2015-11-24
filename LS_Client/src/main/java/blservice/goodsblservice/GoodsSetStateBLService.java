package blservice.goodsblservice;

import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;

public interface GoodsSetStateBLService {
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

}
