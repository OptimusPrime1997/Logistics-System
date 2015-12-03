package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import util.enumData.goodsState;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsCheckValidBLService;

public class GoodsCheckValidController implements GoodsCheckValidBLService{
	private Goodsbl goodsbl = new Goodsbl();

	@Override
	public ResultMessage checkListNum(String listNum) {
		return goodsbl.ifListNumValid(listNum);
	}
	@Override
	public ResultMessage checkifWritten(String str){
		return goodsbl.ifWritten(str);
	}
}
