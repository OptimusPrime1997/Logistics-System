package blservice.goodsblservice;

import java.util.ArrayList;

import VO.GoodsVO;

public interface GoodsGetByCouriersBLService {
	/**
	 * return the number of goods the courier get,recent days
	 * @param numOfDays
	 * @return
	 */
	public int[] getdaysNumOfGoods(int numOfDays);
	
	/**
	 * return all the goods started by a courier,whose accountNumber is given
	 * @param CourierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum,String date);
	

}
