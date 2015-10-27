package dataimpl.receiptdataimpl;

import java.util.ArrayList;

import PO.*;
import state.goodsState;

public class GetRepDataImpl extends ReceiptDataImpl{
	public String submit(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods){
		repArray.add(new GetRepPO(num,date,shipNum,place,state,goods));
		return null;
	}
}
