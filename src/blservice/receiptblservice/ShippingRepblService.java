package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ShippingRepVO;

public interface ShippingRepblService {
	public ShippingRepVO getShippingRep(String num);
	
	public String submit(String num, String date, state.place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods);
}
