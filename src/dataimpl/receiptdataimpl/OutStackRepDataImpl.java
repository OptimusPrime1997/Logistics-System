package dataimpl.receiptdataimpl;

import dataservice.receiptdataservice.OutStockRepDataService;
import util.enumData.*;

import java.util.ArrayList;

import PO.*;

public class OutStackRepDataImpl extends ReceiptDataImpl implements OutStockRepDataService{

	@Override
	public String submit(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods) {
		repArray.add(new OutStockRepPO(num, date, place, form, carNum, shipNum, goods));
		return null;
	}

}
