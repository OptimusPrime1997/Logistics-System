package dataservice.receiptdataservice;

import java.util.ArrayList;

import VO.GoodsVO;

public interface CashRepDataService {
	public String submit(String num, String date, int money, String getCourierNum, ArrayList<GoodsVO> goods);
}
