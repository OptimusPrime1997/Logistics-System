package blservice.receiptblservice;

import java.util.ArrayList;

import state.Rep;
import state.goodsState;

public interface ReceptionRepblService extends ReceiptblService{
	public String updateRep (Rep rep, String number);
	
	public String submit(String num, String date, state.place place, String shipNum, goodsState state,
			ArrayList<String> goods);
}
