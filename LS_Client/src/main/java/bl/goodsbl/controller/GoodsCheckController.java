package bl.goodsbl.controller;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsCheckBLService;

public class GoodsCheckController implements GoodsCheckBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public GoodsVO check(String listNum) {
		return goodsbl.check(listNum);
	}

}
