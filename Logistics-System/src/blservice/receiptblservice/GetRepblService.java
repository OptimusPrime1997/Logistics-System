package blservice.receiptblservice;

import java.util.ArrayList;

import state.Rep;
import state.goodsState;

public interface GetRepblService extends ReceiptblService{
	public String updateShip (Rep rep, String num);
	
	public String submit(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods);
}
