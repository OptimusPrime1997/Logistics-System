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
	public static GoodsLogisticState get(int i){
		switch(i){
		case 0:return SENDED;
		case 1:return SENDER_TRANSCENTER_ARRIVED;
		case 2:return RECEIVER_TRANSCENTER_ARRIVED;
		case 3:return RECEIVER_BUSINESSOFFICE_ARRIVED;
		case 4:return DELIVERING;
		case 5:return SIGNED;
		case 6:return BROKEN_OR_LOST;
		default:return null;
		}
	}
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
