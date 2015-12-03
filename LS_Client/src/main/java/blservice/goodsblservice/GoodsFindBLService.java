package blservice.goodsblservice;

import java.util.ArrayList;

import Exception.GoodsNotFound;
import VO.GoodsVO;

public interface GoodsFindBLService {
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
	/**
	 * search for the information of goods by giving the listNumber
	 * @param listNum
	 * @return
	 */
	public GoodsVO check(String listNum)throws GoodsNotFound;

}
