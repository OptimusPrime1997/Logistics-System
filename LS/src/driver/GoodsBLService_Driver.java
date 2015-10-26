package driver;

import VO.GoodsVO;
import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsExpressType;
import bl.goodsbl.GoodsLogisticState;
import blservice.goodsblservice.GoodsBLService;

public class GoodsBLService_Driver {

	GoodsBLService goodsblservice;
	GoodsVO vo;
	public GoodsBLService_Driver(GoodsBLService goodsbl) {
		this.goodsblservice = goodsbl;
	}

	public void drive(GoodsBLService goodsBLService){
		vo=new GoodsVO("0250000123", false, 
				"02400100006014", "02500100006014", "20151026",
				null, "025", "李华", "上海市浦东新区张杨路500号", "上海华润时代广场", 
				"87511426", "陆宏", "南京市栖霞区仙林大道和园12号", null, "15500001112", 
				1, 5, 8, "书", GoodsExpressType.STANTARD ,5, 10, 5, 
				GoodsArrivalState.INTACT, GoodsLogisticState.SENDED, null, null);
		goodsblservice.init(vo);
		goodsblservice.check("0250000123");
		goodsblservice.examine("0250000123", true);
		goodsblservice.setArrivalState("0250000123", GoodsArrivalState.BROKEN);
		goodsblservice.setLogisticState("0250000123", GoodsLogisticState.SENDER_BUSINESSOFFICE_ARRIVED);
		goodsblservice.delete(vo);
		
	}
}
