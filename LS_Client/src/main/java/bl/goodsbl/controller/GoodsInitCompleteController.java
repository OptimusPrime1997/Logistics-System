package bl.goodsbl.controller;

import Exception.ExistException;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsInitCompleteBLService;

public class GoodsInitCompleteController implements GoodsInitCompleteBLService{
	private Goodsbl goodsbl=new Goodsbl();
	@Override
	public GoodsVO getInitCompleteGoods(GoodsVO vo) throws ExistException {
		return goodsbl.initComplete(vo);
	}

}
