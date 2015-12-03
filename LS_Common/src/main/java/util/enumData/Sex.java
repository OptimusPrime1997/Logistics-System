package util.enumData;

public enum Sex {
	Sex_MALE,Sex_FAMALE;
	public static String toString(Sex sex){
		switch (sex) {
		case Sex_MALE:
			return "男";
		case Sex_FAMALE:
			return "女";
		default:
			return null;
		}
	}
}
