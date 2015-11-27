package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsExamineBLService;

public class GoodsExamineController implements GoodsExamineBLService {
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ResultMessage examine(String listNum, Boolean ifPassed) {
		return goodsbl.examine(listNum, ifPassed);

	}
}
