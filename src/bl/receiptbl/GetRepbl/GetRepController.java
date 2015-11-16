package bl.receiptbl.GetRepbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import VO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.GetRepblService;
import util.enumData.Rep;
import util.enumData.goodsState;
import util.enumData.place;

public class GetRepController extends ReceiptController implements GetRepblService{
	GetRepbl GetRep = new GetRepbl();

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return GetRep.updateShip(rep, num);
	}

	@Override
	public String submit(String num, String date, String shipNum, place place, goodsState state,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return GetRep.submit(num, date, shipNum, place, state, goods);
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return GetRep.getShipmentRep(num);
	}

	@Override
	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return GetRep.getShippingRep(num);
	}
	
}
