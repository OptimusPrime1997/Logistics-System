package dataservice.receiptdataservice;

import java.util.ArrayList;

public interface ShipmentRepDataService {
	public String submit(String num, String date, state.place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods);
}
