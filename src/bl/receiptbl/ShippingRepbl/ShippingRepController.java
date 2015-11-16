package bl.receiptbl.ShippingRepbl;

import java.util.ArrayList;

import VO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.ShippingRepblService;
import util.enumData.place;

public class ShippingRepController extends ReceiptController implements ShippingRepblService{
	ShippingRepbl ShippingRep = new ShippingRepbl();
	
	@Override
	public ArrayList<ShippingRepVO> forpay(){
		return ShippingRep.forpay();
	}
	
	@Override
	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return ShippingRep.getShippingRep(num);
	}

	@Override
	public String submit(String num, String date, place place, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return ShippingRep.submit(num, date, place, plateNum, driverNum, arriveAlready, goods);
	}

}
