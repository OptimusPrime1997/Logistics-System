package bl.goodsbl.controller;

import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsSetStateBLService;

public class GoodsSetStateController implements GoodsSetStateBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public ResultMessage setArrivalState(String listNum, GoodsArrivalState state) {
		return goodsbl.setArrivalState(listNum, state);
	}

	public ResultMessage setLogisticState(String listNum, GoodsLogisticState state) {
		return goodsbl.setLogisticState(listNum, state);
	}

}
