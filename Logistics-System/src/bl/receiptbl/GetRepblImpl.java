package bl.receiptbl;

import java.util.ArrayList;
import VO.*;
import blservice.receiptblservice.GetRepblService;
import state.Rep;
import state.goodsState;

public class GetRepblImpl extends ReceiptRepblImpl implements GetRepblService{

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ShipmentRepVO getShipmentRep(String num){
		ShipmentRepblImpl shipment = new ShipmentRepblImpl();
		return shipment.getShipmentRep(num);
	}
	
	public ShippingRepVO getShippingRep(String num){
		ShippingRepblImpl shipping = new ShippingRepblImpl();
		return shipping.getShippingRep(num);
	}
	
	public String submit(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods){
		return null;
	}

}
