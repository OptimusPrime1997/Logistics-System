package ui.util;

public enum ButtonType {
	SEARCH,LOGIN,EXIT,BIG,
	/**
	 * 输入库存初始数据
	 */
	STOCK_INPUT,
	STOCK_OUT,
	STOCK_IN,
	STOCK_CHECK,
	STOCK_SHOW,
	STOCK_CHANGE,
	/**
	 * 确定
	 */
	OK,CANCEL,
	/**
	 * 新订单
	 */
	NEWGOODS,
	/**
	 * 已签收
	 */
	SIGNED,
	/**
	 * 快件到达
	 */
	ARRIVE,
	/**
	 * 中转中心界面上面的 大按钮
	 */
	ARRIVE_BIG,
	CAR_MANAGEMENT,DRIVER_MANAGEMENT,
	/**
	 * 派件
	 */
	DELIVER,
	/**
	 * 发往中转中心/营业厅
	 */
	TO_TRS_CTR_OR_YYT,
	/**
	 * 发往中转中心
	 */
	TO_TRANSFER_CTR,
	/**
	 * 发往营业厅
	 */
	TO_YYT,
	/**
	 * 记账
	 */
	MONEY_IN_RECORD, 
}
