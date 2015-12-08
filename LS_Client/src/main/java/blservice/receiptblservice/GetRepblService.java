package blservice.receiptblservice;

import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import util.enumData.Rep;

public interface GetRepblService extends ReceiptblService{
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders);
	
	public void transferOver(String num);
}