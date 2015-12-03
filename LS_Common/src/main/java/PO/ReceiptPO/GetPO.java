package PO.ReceiptPO;

import util.enumData.GoodsArrivalState;

public class GetPO {
	private String order;
	private GoodsArrivalState goodsArrivalState;
	public GetPO(String order, GoodsArrivalState goodsArrivalState) {
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
