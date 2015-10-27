package blservice.receiptblservice;

import java.util.ArrayList;

public interface ShippingRepblService {
	public String submit(String num, String date, state.place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods);
}
