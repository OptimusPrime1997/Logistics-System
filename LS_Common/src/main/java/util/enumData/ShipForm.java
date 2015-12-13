package util.enumData;

public enum ShipForm {
	TRUCK,PLANE,TRAIN;
	
	public static String toFrendlyString(ShipForm shipForm){
		switch (shipForm) {
		case TRUCK:
			return "汽运";
		case PLANE:
			return "航运";
		case TRAIN:
			return "火车";
		default:
			return null;
		}
	}
	
	public static ShipForm getShipForm(String ChineseName){
		switch (ChineseName) {
		case "汽运":
			return TRUCK;
		case "航运":
			return PLANE;
		case "火车":
			return TRAIN;
		default:
			return null;
		}
	}
}
