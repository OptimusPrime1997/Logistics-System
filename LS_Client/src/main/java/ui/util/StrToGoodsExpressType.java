package ui.util;

import util.enumData.GoodsExpressType;

public class StrToGoodsExpressType {
	public static GoodsExpressType toExpressType(String str){
		switch (str) {
		case "标准":return GoodsExpressType.NORMAL;
		case "经济":return GoodsExpressType.ECONOMIC;
		case "特快":return GoodsExpressType.EXPRESS;
		default: return GoodsExpressType.NORMAL;
		}
	}
}
