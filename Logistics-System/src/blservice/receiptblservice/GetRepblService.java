package blservice.receiptblservice;

import java.util.ArrayList;

import state.Rep;
import state.goodsState;

public interface GetRepblService extends ReceiptblService{
	/**
	 * 将到达的营业厅装车单或中转中心装车单的属性改为“已到达”
	 * @param rep
	 * @param num
	 * @return
	 */
	public String updateShip (Rep rep, String num);
	
	public String submit(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods);
}
