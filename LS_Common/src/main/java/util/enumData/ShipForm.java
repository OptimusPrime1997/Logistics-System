package util.enumData;

public enum ShipForm {
	SHIP,PLANE,TRAIN;
	
	public static String toFrendlyString(ShipForm shipForm){
		switch (shipForm) {
		case SHIP:
			return "轮船";
		case PLANE:
			return "空运";
		case TRAIN:
			return "火车";
			

		default:
			return null;
		}
	}
}
