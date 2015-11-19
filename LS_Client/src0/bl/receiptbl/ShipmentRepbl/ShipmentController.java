package bl.receiptbl.ShipmentRepbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.ShipmentRepblServce;
import util.enumData.place;

public class ShipmentController extends ReceiptController implements ShipmentRepblServce{
	ShipmentRepbl ShipmentRep = new ShipmentRepbl();

	@Override
	public ArrayList<ShipmentRepVO> forpay(){
		return ShipmentRep.forpay();
	}
	
	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return ShipmentRep.getShipmentRep(num);
	}

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return ShipmentRep.submit(num, date, place, plateNum, driverNum, arriveAlready, goods);
	}

}
