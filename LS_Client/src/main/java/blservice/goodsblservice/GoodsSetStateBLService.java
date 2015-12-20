package blservice.goodsblservice;

import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;

public interface GoodsSetStateBLService {
	/**
	 * set the arrival state of goods whose listNumber is given
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setArrivalState(String listNum,GoodsArrivalState state,String date);
	/**
	 * set the logistic state of goods whose listNumber is given
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setLogisticState(String listNum,GoodsLogisticState state,String date);

}
