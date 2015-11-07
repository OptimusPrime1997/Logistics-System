package bl.receiptbl;

import java.util.ArrayList;

import VO.ShippingRepVO;
import blservice.receiptblservice.*;
import state.place;

public class ShippingRepblImpl extends ReceiptRepblImpl implements ShippingRepblService{
	public ArrayList<ShippingRepVO> forpay(){
		return null;
	}

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return null;
	}
}
