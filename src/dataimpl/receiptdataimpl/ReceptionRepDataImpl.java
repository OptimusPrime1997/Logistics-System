package dataimpl.receiptdataimpl;

import dataservice.receiptdataservice.ReceptionRepDataService;
import util.enumData.*;

import java.util.ArrayList;

import PO.*;

public class ReceptionRepDataImpl extends ReceiptDataImpl implements ReceptionRepDataService{

	@Override
	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		repArray.add(new ReceptionRepPO(num, date, place, shipNum, state, goods));
		return null;
	}

}
