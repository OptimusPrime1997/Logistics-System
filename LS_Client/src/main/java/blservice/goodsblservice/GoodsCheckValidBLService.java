package blservice.goodsblservice;

import util.enumData.ResultMessage;

public interface GoodsCheckValidBLService {
	/**
	 * 检查订单号是否合法
	 * @param listNum
	 * @return
	 */
	public ResultMessage checkListNum(String listNum);

	/**
	 * 检查是否填写
	 */
	public ResultMessage checkifWritten(String str);
}
