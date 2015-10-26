package bl.goodsbl;

import java.util.ArrayList;

import VO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;

public class Goodsbl implements GoodsBLService{

	@Override
	public GoodsVO check(String listNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean init(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(GoodsVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void examine(String listNum, Boolean ifPassed) {
		// TODO Auto-generated method stub
		
	}

}
