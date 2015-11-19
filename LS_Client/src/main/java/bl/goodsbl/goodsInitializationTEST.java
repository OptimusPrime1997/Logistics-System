package bl.goodsbl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VO.GoodsVO;

public class goodsInitializationTEST {
	@Test
	public void test() {
		Goodsbl goodsbl = new Goodsbl();
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
		assertEquals((int)vo_.moneyFare,(int) goodsbl.init(vo).moneyFare);
		assertEquals((int)vo_.moneyTotal,(int) goodsbl.init(vo).moneyTotal);

	}
}
