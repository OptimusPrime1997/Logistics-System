package bl.receiptbl.OutStockRepbl;

import java.util.ArrayList;

import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.OutStockRepblService;
import util.enumData.ShipForm;
import util.enumData.place;

public class OutStockRepController extends ReceiptController implements OutStockRepblService{
	OutStackRepbl OutStackRepbl = new OutStackRepbl();

	@Override
	public String submit(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return OutStackRepbl.submit(num, date, place, form, carNum, shipNum, goods);
	}

}
