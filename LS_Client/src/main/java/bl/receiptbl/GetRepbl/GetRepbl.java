package bl.receiptbl.GetRepbl;

import VO.*;
import bl.receiptbl.Receiptbl.ReceiptblController;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import util.enumData.Rep;

public class GetRepbl extends ReceiptblController{

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
	
}
