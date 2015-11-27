package bl.goodsbl.controller;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsGetByCouriersBLService;

public class GoodsGetByCourierController implements GoodsGetByCouriersBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum,String date) {
		return goodsbl.getGoodsByCourier(CourierNum,date);
	}
	@Override
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum,String date) {
		return goodsbl.getGoodsByGetCourier(CourierNum,date);
	}

}
