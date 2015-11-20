package blservice.goodsblservice;

import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsLogisticState;

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
