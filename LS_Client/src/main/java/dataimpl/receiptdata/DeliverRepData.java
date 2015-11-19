package dataimpl.receiptdata;

import java.util.ArrayList;

import PO.*;

public class DeliverRepData extends ReceiptData{
	
	public String submit(String num, String date, String deliverCourierNum, ArrayList<String> goods){
		repArray.add(new DeliverRepPO(num,date,deliverCourierNum, goods));
		return null;
	}
}
