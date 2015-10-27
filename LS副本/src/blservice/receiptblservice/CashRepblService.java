package blservice.receiptblservice;

import java.util.ArrayList;

import VO.GoodsVO;

public interface CashRepblService extends ReceiptblService{
	public String submit(String num, String date, int money, String getCourierNum);
	
	public String submit(String num, String date, int money, String getCourierNum, ArrayList<GoodsVO> goods);
}
