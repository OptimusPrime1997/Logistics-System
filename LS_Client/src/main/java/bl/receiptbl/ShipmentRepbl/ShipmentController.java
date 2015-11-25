package bl.receiptbl.ShipmentRepbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShipmentRepblServce;

public class ShipmentController extends ReceiptblController implements ShipmentRepblServce{
	ShipmentRepbl ShipmentRep = new ShipmentRepbl();

	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return ShipmentRep.getShipmentRep(num);
	}

	public ArrayList<ShipmentRepVO> forpay() {
		// TODO Auto-generated method stub
		return ShipmentRep.forpay();
	}


}
