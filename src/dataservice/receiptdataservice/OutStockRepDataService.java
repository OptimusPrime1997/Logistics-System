package dataservice.receiptdataservice;

import java.util.ArrayList;

import util.enumData.*;

public interface OutStockRepDataService {
	public String submit(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods);
}
