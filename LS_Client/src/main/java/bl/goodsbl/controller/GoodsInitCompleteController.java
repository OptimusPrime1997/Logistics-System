package bl.goodsbl.controller;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsInitCompleteBLService;

public class GoodsInitCompleteController implements GoodsInitCompleteBLService{
	private Goodsbl goodsbl=new Goodsbl();
	@Override
	public GoodsVO getInitCompleteGoods(GoodsVO vo) {
		return goodsbl.getCalculatedGoods(vo);
	}

}
