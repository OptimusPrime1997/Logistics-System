package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsInitBLService;

public class GoodsInitController implements GoodsInitBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public ResultMessage init(GoodsVO vo) {
		return goodsbl.init(vo);
	}

}