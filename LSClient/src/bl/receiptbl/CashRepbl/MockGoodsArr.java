package bl.receiptbl.CashRepbl;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsExpressType;
import bl.goodsbl.GoodsLogisticState;

public class MockGoodsArr {
	public ArrayList<GoodsVO> getGoods(String courierNum){
		ArrayList<GoodsVO> goods = new ArrayList<GoodsVO>();
		GoodsVO vo = new GoodsVO("0250000123", false, "02400100006014",
				"02500100006014", "20151026", "", "025", "李华",
				"上海市浦东新区张杨路500号", "上海华润时代广场", "87511426", "陆宏",
				"南京市栖霞区仙林大道和园12号", null, "15500001112", 1, 5, 8, "书",
				GoodsExpressType.NORMAL, 5, 0, 0, GoodsArrivalState.INTACT,
				GoodsLogisticState.SENDED, null, null);
		
		GoodsVO vo_ = new GoodsVO("0250000123", false, "02400100006014",
				"02500100006014", "20151026", "", "025", "李华",
				"上海市浦东新区张杨路500号", "上海华润时代广场", "87511426", "陆宏",
				"南京市栖霞区仙林大道和园12号", null, "15500001112", 1, 5, 8, "书",
				GoodsExpressType.NORMAL, 5, 15, 10, GoodsArrivalState.INTACT,
				GoodsLogisticState.SENDED, null, null);
		goods.add(vo);
		goods.add(vo_);
		return goods;
	}
}
