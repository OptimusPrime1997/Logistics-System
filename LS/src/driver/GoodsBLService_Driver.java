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
		vo=new GoodsVO("0250000123", false, "02400100006014", "02500100006014", "20151026", null, "025", "�", "�Ϻ����ֶ���������·500��", "�Ϻ�����ʱ���㳡", "87511426", "½��", "�Ͼ�����ϼ�����ִ����԰12��", null, "15500001112", 1, 5, 8, "��", GoodsExpressType.STANTARD ,5, 10, 5, GoodsArrivalState.INTACT, GoodsLogisticState.SENDED, null, null);
		initGoods(vo);
	}
	public void initGoods(GoodsVO vo){
		
	}
}
