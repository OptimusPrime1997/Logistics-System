package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsDeleteBLService;

public class GoodsDeleteController implements GoodsDeleteBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ResultMessage delete(GoodsVO vo) {
		return goodsbl.delete(vo);
	}
}
