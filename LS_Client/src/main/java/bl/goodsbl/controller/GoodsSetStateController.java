package bl.goodsbl.controller;

import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsLogisticState;
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
