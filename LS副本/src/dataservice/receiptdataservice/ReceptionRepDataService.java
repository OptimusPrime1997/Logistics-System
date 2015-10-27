package dataservice.receiptdataservice;

import java.util.ArrayList;

import state.goodsState;

public interface ReceptionRepDataService {
	public String submit(String num, String date, state.place place, String shipNum, goodsState state,
			ArrayList<String> goods);
}
