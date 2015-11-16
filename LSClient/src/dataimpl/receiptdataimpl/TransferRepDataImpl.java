package dataimpl.receiptdataimpl;

import java.util.ArrayList;

import PO.TransferRepPO;
import dataservice.receiptdataservice.TransferRepDataService;
import util.enumData.*;

public class TransferRepDataImpl extends ReceiptDataImpl implements TransferRepDataService{

	@Override
	public String submit(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		repArray.add(new TransferRepPO(num, date, form, carNum, place, container, arriveAlready, goods));
		return null;
	}

}
