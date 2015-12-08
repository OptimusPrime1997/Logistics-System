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
	BROKEN_OR_LOST;
public static String toFriendlyString(GoodsLogisticState st){
		switch (st) {
		case SENDED:
			return "快件已寄出";
		case SENDER_TRANSCENTER_ARRIVED:
			return "快件已到达寄件人中转中心";
		case RECEIVER_TRANSCENTER_ARRIVED:
			return " 快件已到达收件人中转中心";
		case RECEIVER_BUSINESSOFFICE_ARRIVED:
			return "快件已到达收件人营业厅";

		case DELIVERING:
			return "派件中";

		case SIGNED:
			return "快件已被签收";

		case BROKEN_OR_LOST:
			return "快件已丢损";
		default:
			return "已签收";
		}
	}
}
