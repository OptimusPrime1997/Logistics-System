package bl.goodsbl.controller;

import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.ResultMessage;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsSetStateBLService;

public class GoodsSetStateController implements GoodsSetStateBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ResultMessage setArrivalState(String listNum, GoodsArrivalState state,String date) {
		return goodsbl.setArrivalState(listNum, state,date);
	}
	@Override
	public ResultMessage setLogisticState(String listNum, GoodsLogisticState state,String date) {
		return goodsbl.setLogisticState(listNum, state,date);
	}

}
