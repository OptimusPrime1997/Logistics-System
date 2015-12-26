package PO.Receipt;

import java.io.Serializable;

import util.enumData.GoodsArrivalState;

public class ArrivePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
