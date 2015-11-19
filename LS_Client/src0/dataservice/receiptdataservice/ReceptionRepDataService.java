package dataservice.receiptdataservice;

import java.util.ArrayList;

import util.enumData.*;

public interface ReceptionRepDataService {
	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods);
}
