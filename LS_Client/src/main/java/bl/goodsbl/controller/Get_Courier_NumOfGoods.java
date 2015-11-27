package bl.goodsbl.controller;

import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GetNumOfGoodsByCourier;

public class Get_Courier_NumOfGoods implements GetNumOfGoodsByCourier {
	private Goodsbl goodsbl=new Goodsbl();
	@Override 
	public int[] getdaysNumOfGoods(int numOfDays) {
		return goodsbl.get7daysNumOfGoods(numOfDays);
	}

}
