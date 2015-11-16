package dataimpl.receiptdataimpl;

import java.util.ArrayList;

import PO.ShipmentRepPO;
import dataservice.receiptdataservice.ShipmentRepDataService;
import util.enumData.*;

public class ShipmentRepDataImpl extends ReceiptDataImpl implements ShipmentRepDataService{

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		repArray.add(new ShipmentRepPO(num, date, place, plateNum, driverNum, arriveAlready, goods));
		return null;
	}

}
