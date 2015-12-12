package util.enumData;

public enum City {
	BEIJING, NANJING, SHANGHAI, GUANGZHOU;
	public static String toString(City city) {
		switch (city) {
		case BEIJING:
			return "北京";
		case NANJING:
			return "南京";
		case SHANGHAI:
			return "上海";
		case GUANGZHOU:
			return "广州";
		default:
			break;
		}
		return null;
	}
	
	public static int toInt(City city) {
		switch (city) {
		case BEIJING:
			return 1;
		case NANJING:
			return 3;
		case SHANGHAI:
			return 5;
		case GUANGZHOU:
			return 7;
		default:
			break;
		}
		return 0;
	}
	
	public static City getCity(String ChineseName){
		switch (ChineseName) {
		case "北京":
			return BEIJING;
		case "南京":
			return NANJING;
		case "上海":
			return SHANGHAI;
		case "广州":
			return GUANGZHOU;
		default:
			return null;
		}
	}
}
