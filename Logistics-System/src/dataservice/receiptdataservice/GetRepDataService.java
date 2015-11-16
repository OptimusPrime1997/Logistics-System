package dataservice.receiptdataservice;

import java.util.ArrayList;
import util.enumData.*;

public interface GetRepDataService {
	public String submit(String num, String date, String shipNum, place place, goodsState state,
			ArrayList<String> goods);
}
