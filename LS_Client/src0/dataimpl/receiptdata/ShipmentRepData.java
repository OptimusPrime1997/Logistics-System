package dataimpl.receiptdata;

import java.util.ArrayList;

import PO.ShipmentRepPO;
import dataservice.receiptdataservice.ShipmentRepDataService;
import util.enumData.*;

public class ShipmentRepData extends ReceiptData implements ShipmentRepDataService{

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		repArray.add(new ShipmentRepPO(num, date, place, plateNum, driverNum, arriveAlready, goods));
		return null;
	}

}
