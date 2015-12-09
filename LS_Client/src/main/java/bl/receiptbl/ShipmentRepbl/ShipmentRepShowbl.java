package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;
import VO.ReceiptVO.ShipmentRepVO;

public class ShipmentRepShowbl {
	
	private ShipmentRepbl shipmentRepbl = new ShipmentRepbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ShipmentRepVO shipmentRepVO = shipmentRepbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders = shipmentRepVO.goods;
		for(int i = 0;i < orders.size();i++){
			data.add(orders.get(i));
		}
		return data;
	}

}
