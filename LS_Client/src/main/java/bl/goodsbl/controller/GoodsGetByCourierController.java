package bl.goodsbl.controller;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsGetByCouriersBLService;

public class GoodsGetByCourierController implements GoodsGetByCouriersBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public int[] getdaysNumOfGoods(int numOfDays) {
		return goodsbl.get7daysNumOfGoods(numOfDays);
	}
	@Override
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum,String date) {
		return goodsbl.getGoodsByGetCourier(CourierNum,date);
	}

}
