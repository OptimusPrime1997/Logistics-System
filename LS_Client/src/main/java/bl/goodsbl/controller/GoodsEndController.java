package bl.goodsbl.controller;

import util.enumData.ResultMessage;
import bl.goodsbl.Goodsbl;
import blservice.goodsblservice.GoodsEndBLService;

public class GoodsEndController implements GoodsEndBLService {
	private Goodsbl goodsbl = new Goodsbl();
	@Override
	public ResultMessage end(String listNum,String date, String realReceiverName,
			String realReceiverPhone) {
		return goodsbl.end(listNum,date, realReceiverName, realReceiverPhone);
	}

}
