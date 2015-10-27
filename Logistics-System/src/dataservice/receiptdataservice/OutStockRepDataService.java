package dataservice.receiptdataservice;

import java.util.ArrayList;

import state.ShipForm;

public interface OutStockRepDataService {
	public String submit(String num, String date, state.place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods);
}
