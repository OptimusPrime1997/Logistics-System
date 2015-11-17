package dataimpl.receiptdata;

import dataservice.receiptdataservice.ReceptionRepDataService;
import util.enumData.*;

import java.util.ArrayList;

import PO.*;

public class ReceptionRepData extends ReceiptData implements ReceptionRepDataService{

	@Override
	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		repArray.add(new ReceptionRepPO(num, date, place, shipNum, state, goods));
		return null;
	}

}
