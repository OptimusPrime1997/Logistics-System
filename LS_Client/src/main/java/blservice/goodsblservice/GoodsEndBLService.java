package blservice.goodsblservice;

import util.enumData.ResultMessage;

public interface GoodsEndBLService {

	/**
	 * 输入收件信息~
	 * @param listNum
	 * @param realReceiverName
	 * @param realReceiverPhone
	 * @return
	 */
	public ResultMessage end(String listNum,String realReceiverName,String realReceiverPhone);

}
