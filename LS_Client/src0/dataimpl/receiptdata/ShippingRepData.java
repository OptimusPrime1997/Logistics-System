package dataimpl.receiptdata;

import dataservice.receiptdataservice.ShippingRepDataService;
import util.enumData.*;

import java.util.ArrayList;

import PO.*;

public class ShippingRepData extends ReceiptData implements ShippingRepDataService{

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		repArray.add(new ShippingRepPO(num, date, place, plateNum, driverNum, arriveAlready ,goods));
		return null;
	}

}
