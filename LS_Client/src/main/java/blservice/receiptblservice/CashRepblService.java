package blservice.receiptblservice;

import java.util.ArrayList;

import VO.GoodsVO;
import util.enumData.ResultMessage;

public interface CashRepblService extends ReceiptblService{
	/**
	 * 提交收款单
	 * @param num
	 * @param date
	 * @param money
	 * @param courierNum
	 * @param goods
	 * @return
	 */
	public ResultMessage submit(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods);

	/**
	 * 通过快递员编号得到快递员一天收到所有货物
	 * @param courierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoods(String text);

	/**
	 * 通过快递员编号得到名字
	 * @param courierNum
	 * @return
	 */
	public String getCourierName(String text);

	/**
	 * 得到 一批货物的总钱数
	 * @param arrGoods
	 * @return
	 */
	public double getMoneySum(ArrayList<GoodsVO> arrGoods);
}