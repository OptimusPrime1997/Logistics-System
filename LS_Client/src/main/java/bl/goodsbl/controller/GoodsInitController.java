package bl.goodsbl.controller;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsInitBLService;

public class GoodsInitController implements GoodsInitBLService{
	private Goodsbl goodsbl = new Goodsbl();
	public GoodsVO init(GoodsVO vo) {
		return goodsbl.init(vo);
	}

}
//
//	private Goodsbl goodsbl = new Goodsbl();
//
//
//	public void examine(String listNum, Boolean ifPassed) {
//		goodsbl.examine(listNum, ifPassed);
//		
//	}
