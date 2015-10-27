package dataservice.receiptdataservice;

import java.util.ArrayList;

import state.ShipForm;

public interface TransferRepDataService {
	public String submit(String num, String date, ShipForm form, String carNum, state.place place, int container,
			boolean arriveAlready, ArrayList<String> goods);
}
