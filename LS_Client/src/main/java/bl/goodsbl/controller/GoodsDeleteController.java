package bl.goodsbl.controller;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsDeleteBLService;

public class GoodsDeleteController implements GoodsDeleteBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public Boolean delete(GoodsVO vo) {
		return goodsbl.delete(vo);
	}
}
