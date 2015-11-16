package bl.receiptbl.GetRepbl;

import java.util.ArrayList;
import VO.*;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import util.enumData.Rep;
import util.enumData.goodsState;

public class GetRepbl extends Receiptbl{

	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ShipmentRepVO getShipmentRep(String num){
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getShipmentRep(num);
	}
	
	public ShippingRepVO getShippingRep(String num){
		ShippingRepbl shipping = new ShippingRepbl();
		return shipping.getShippingRep(num);
	}
	
	public String submit(String num, String date, String shipNum, util.enumData.place place, goodsState state,
			ArrayList<String> goods){
		return null;
	}

}
