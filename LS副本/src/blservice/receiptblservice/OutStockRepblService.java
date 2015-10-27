package blservice.receiptblservice;

import java.util.ArrayList;

import VO.OutStockRepVO;
import state.ShipForm;

public interface OutStockRepblService extends ReceiptblService{
	public OutStockRepVO get (String date);
	
	public String submit(String num, String date, state.place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods);
}
