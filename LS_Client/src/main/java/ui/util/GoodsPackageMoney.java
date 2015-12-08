package ui.util;

public class GoodsPackageMoney {
	public static double packageToMoney(String pkgType){
		switch(pkgType){
		// "快递袋", "纸箱", "木箱"
		case "快递袋":
			return 1;
		case "纸箱":
		    return 3;
		case "木箱":
			return 5;
		default:return 0;
		}
	}
}
