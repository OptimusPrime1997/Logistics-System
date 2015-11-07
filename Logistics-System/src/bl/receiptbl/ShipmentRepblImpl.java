package bl.receiptbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import blservice.receiptblservice.ShipmentRepblServce;
import state.place;

public class ShipmentRepblImpl extends ReceiptblImpl implements ShipmentRepblServce{
	public ArrayList<ShipmentRepVO> forpay(){
		return null;
	}

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return null;
	}
}
