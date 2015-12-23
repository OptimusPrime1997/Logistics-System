package util.enumData;

public enum City implements Comparable<City> {
	BEIJING(21, "北京"), GUANGZHOU(27, "广州"), NANJING(23, "南京"), SHANGHAI(25,
			"上海");
	private int index;
	private String value;

	private City(int index, String value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public String toString() {
		return value;
	}

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

	public static City getCity(String ChineseName) {
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
