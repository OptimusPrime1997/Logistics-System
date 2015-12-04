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
}
