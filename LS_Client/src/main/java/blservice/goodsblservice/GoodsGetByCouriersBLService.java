package blservice.goodsblservice;

import java.util.ArrayList;

import VO.GoodsVO;

public interface GoodsGetByCouriersBLService {
	/**
	 * return all the goods started or ended by a courier,whose accountNumber is given
	 * @param CourierNum
	 * @return
	 */
	public int getGoodsByCourier(String CourierNum,String date);
	
	/**
	 * return all the goods started by a courier,whose accountNumber is given
	 * @param CourierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum,String date);
	

}
