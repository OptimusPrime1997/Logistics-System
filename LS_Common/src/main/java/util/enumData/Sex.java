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
