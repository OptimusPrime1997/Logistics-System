package bl.goodsbl.controller;

import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsExamineBLService;

public class GoodsExamineController implements GoodsExamineBLService {
	private Goodsbl goodsbl = new Goodsbl();
	public void examine(String listNum, Boolean ifPassed) {
		goodsbl.examine(listNum, ifPassed);

	}
}
