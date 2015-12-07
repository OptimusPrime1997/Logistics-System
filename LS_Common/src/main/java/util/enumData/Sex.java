package util.enumData;

public enum Sex {
	Sex_MALE(0, "男"), Sex_FAMALE(1, "女");
	final private int index;
	final private String value;

	private Sex(int index, String value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}

	public static String toString(Sex sex) {
		switch (sex) {
		case Sex_MALE:
			return "男";
		case Sex_FAMALE:
			return "女";
		default:
			return null;
		}
	}

	public static int toNum(Sex sex) {
		// TODO Auto-generated method stub
		switch (sex) {
		case Sex_MALE:
			return 0;
		case Sex_FAMALE:
			return 1;
		default:
			break;
		}
		return 0;
	}
}
