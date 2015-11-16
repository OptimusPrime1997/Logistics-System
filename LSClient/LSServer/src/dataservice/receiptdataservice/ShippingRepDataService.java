package dataservice.receiptdataservice;

import java.util.ArrayList;
import util.enumData.*;

public interface ShippingRepDataService {
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods);
}
