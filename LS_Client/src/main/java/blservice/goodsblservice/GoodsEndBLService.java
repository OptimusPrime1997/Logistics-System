package blservice.goodsblservice;

import util.enumData.ResultMessage;

public interface GoodsEndBLService {

	public ResultMessage end(String listNum,String realReceiverName,String realReceiverPhone);

}
