package bl.goodsbl.controller;

import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GetNumOfGoodsByCourierBLService;

public class Get_Courier_NumOfGoodsController implements GetNumOfGoodsByCourierBLService {
	private Goodsbl goodsbl=new Goodsbl();
	@Override 
	public int[] getdaysNumOfGoods(int numOfDays) {
		return goodsbl.get7daysNumOfGoods(numOfDays);
	}

}
