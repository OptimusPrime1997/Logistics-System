package dataservice.receiptdataservice;

import java.util.ArrayList;

import state.goodsState;

public interface GetRepDataService {
	public String submit(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods);
}
