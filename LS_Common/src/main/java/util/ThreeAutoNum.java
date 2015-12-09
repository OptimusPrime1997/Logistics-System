package util;

public class ThreeAutoNum {
	public static String toThreeNum(int n) {
		if (n >= 0 && n < 10) {
			return "00" + n;
		} else if (n > 10 && n < 100) {
			return "0" + n;
		} else if (n >= 100 && n < 1000) {
			return n + "";
		} else {
			return null;
		}
	}
}
