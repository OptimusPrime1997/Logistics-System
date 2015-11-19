package dataservice.receiptdataservice;

import java.util.ArrayList;

public interface DeliverRepDataService {
	public String submit(String num, String date, String deliverCourierNum, ArrayList<String> goods);
}
