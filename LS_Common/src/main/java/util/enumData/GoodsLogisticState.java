package util.enumData;

public enum GoodsLogisticState {
	/**
	 * 已寄出
	 */
	SENDED, 
	/**
	 * 到达寄件人中转中心
	 */
	SENDER_TRANSCENTER_ARRIVED, 
	/**
	 * 到达收件人中转中心
	 */
	RECEIVER_TRANSCENTER_ARRIVED, 
	/**
	 * 到达收件人营业厅
	 */
	RECEIVER_BUSINESSOFFICE_ARRIVED, 
	/**
	 * 派件中
	 */
	DELIVERING,
	/**
	 * 已签收
	 */
	SIGNED, 
	/**
	 * 已丢损，终止物流
	 */
	BROKEN_OR_LOST
}
