package PO.ReceiptPO;

import util.enumData.GoodsArrivalState;

public class ArrivePO {
	private String order;
	private GoodsArrivalState goodsArrivalState;
	public ArrivePO(String order, GoodsArrivalState goodsArrivalState) {
		super();
		this.order = order;
		this.goodsArrivalState = goodsArrivalState;
	}
	public String getOrder() {
		return order;
	}
	public GoodsArrivalState getGoodsArrivalState() {
		return goodsArrivalState;
	}
}
