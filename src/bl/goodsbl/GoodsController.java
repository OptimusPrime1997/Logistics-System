package bl.goodsbl;

import java.util.ArrayList;

import VO.GoodsVO;
import blservice.goodsblservice.GoodsBLService;

public class GoodsController implements GoodsBLService{
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public GoodsVO check(String listNum) {
		return goodsbl.check(listNum);
	}

	@Override
	public Boolean init(GoodsVO vo) {
		return goodsbl.init(vo);
	}

	@Override
	public Boolean delete(GoodsVO vo) {
		return goodsbl.delete(vo);
	}

	@Override
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum) {
		return goodsbl.getGoodsByCourier(CourierNum);
	}

	@Override
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		return goodsbl.setArrivalState(listNum, state);
	}

	@Override
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		return goodsbl.setLogisticState(listNum, state);
	}

	@Override
	public void examine(String listNum, Boolean ifPassed) {
		goodsbl.examine(listNum, ifPassed);
		
	}

}
