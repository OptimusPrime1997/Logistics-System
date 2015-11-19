package dataservice.receiptdataservice;

import java.util.ArrayList;

import util.enumData.*;

public interface TransferRepDataService {
	public String submit(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods);
}
