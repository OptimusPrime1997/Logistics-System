package blservice.receiptblservice;

import java.util.ArrayList;

import VO.GoodsVO;

public interface CashRepblService extends ReceiptblService{
	public String submit(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods);

	public ArrayList<GoodsVO> getGoods(String text);

	public String getCourierName(String text);
}
