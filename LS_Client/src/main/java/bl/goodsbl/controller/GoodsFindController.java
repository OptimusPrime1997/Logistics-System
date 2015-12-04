package bl.goodsbl.controller;

import java.util.ArrayList;

import Exception.CourierNotFoundException;
import Exception.GoodsNotFound;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsFindBLService;

public class GoodsFindController implements GoodsFindBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public int[] getdaysNumOfGoods(int numOfDays) {
		return goodsbl.get7daysNumOfGoods(numOfDays);
	}
	@Override
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum,String date) {
		return goodsbl.getGoodsByGetCourier(CourierNum,date);
	}
	@Override
	public GoodsVO check(String listNum) throws GoodsNotFound {
		return goodsbl.findByListNum(listNum);
	}

}
