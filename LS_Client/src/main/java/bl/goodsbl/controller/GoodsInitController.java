package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import Exception.ExistException;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsInitBLService;

public class GoodsInitController implements GoodsInitBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ResultMessage init(GoodsVO vo) {
		return goodsbl.init(vo);
	}
	@Override
	public GoodsVO initCompleteGoods(GoodsVO vo) throws ExistException {
		return goodsbl.initComplete(vo);
	}

}