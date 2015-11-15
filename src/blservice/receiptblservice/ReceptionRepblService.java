package blservice.receiptblservice;

import java.util.ArrayList;

import state.Rep;
import state.goodsState;

public interface ReceptionRepblService extends ReceiptblService{
	/**
	 * 将到达的中转单或中转中心装车单的属性改为“已到达”
	 * @param rep
	 * @param number
	 * @return
	 */
	public String updateShip (Rep rep, String num);
	
	public String submit(String num, String date, state.place place, String shipNum, goodsState state,
			ArrayList<String> goods);
}
