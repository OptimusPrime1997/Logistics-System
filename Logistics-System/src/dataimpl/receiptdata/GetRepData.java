package dataimpl.receiptdata;

import java.util.ArrayList;

import util.enumData.goodsState;
import util.enumData.place;
import PO.GetRepPO;

public class GetRepData extends ReceiptData{
	public String submit(String num, String date, String shipNum, place place, goodsState state,
			ArrayList<String> goods){
		repArray.add(new GetRepPO(num,date,shipNum,place,state,goods));
		return null;
	}
}
