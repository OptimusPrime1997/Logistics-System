package bl.goodsbl.controller;

import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsSetStateBLService;

public class GoodsSetStateController implements GoodsSetStateBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		return goodsbl.setArrivalState(listNum, state);
	}

	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		return goodsbl.setLogisticState(listNum, state);
	}

}
