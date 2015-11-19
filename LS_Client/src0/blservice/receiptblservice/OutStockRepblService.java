package blservice.receiptblservice;

import java.util.ArrayList;

import VO.OutStockRepVO;
import util.enumData.ShipForm;

public interface OutStockRepblService extends ReceiptblService{

	public String submit(String num, String date, util.enumData.place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods);
}
