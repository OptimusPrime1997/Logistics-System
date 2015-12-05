package bl.goodsbl.controller;

import util.InputCheck;
import util.enumData.ResultMessage;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsCheckValidBLService;

public class GoodsCheckValidController implements GoodsCheckValidBLService{
	private Goodsbl goodsbl = new Goodsbl();

	@Override
	public ResultMessage checkListNum(String listNum) {
		return InputCheck.checkListNum(listNum);
	}
	@Override
	public ResultMessage checkifWritten(String str){
		return InputCheck.ifWritten(str);
	}
}
