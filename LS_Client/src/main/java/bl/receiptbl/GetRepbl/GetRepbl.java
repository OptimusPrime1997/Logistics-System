package bl.receiptbl.GetRepbl;

import java.util.ArrayList;

import VO.*;
import bl.receiptbl.Receiptbl.ReceiptblController;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import util.enumData.Rep;
import util.enumData.ResultMessage;

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

	public String createNum(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int n) {
		// TODO Auto-generated method stub
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
	}

	public GetRepVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public void submit(ReceiptVO vo) {
		// TODO Auto-generated method stub
	}

	public ArrayList<GetRepVO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GetRepVO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
